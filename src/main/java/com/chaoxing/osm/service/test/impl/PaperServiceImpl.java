package com.chaoxing.osm.service.test.impl;

import com.chaoxing.osm.bean.dto.test.AnswerDTO;
import com.chaoxing.osm.bean.dto.test.PaperDTO;
import com.chaoxing.osm.bean.po.test.Paper;
import com.chaoxing.osm.bean.po.test.PaperLog;
import com.chaoxing.osm.bean.po.test.PaperMark;
import com.chaoxing.osm.bean.po.test.PaperQuestion;
import com.chaoxing.osm.common.ResponseString;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.dao.test.PaperLogMapper;
import com.chaoxing.osm.dao.test.PaperMapper;
import com.chaoxing.osm.dao.test.PaperMarkMapper;
import com.chaoxing.osm.dao.test.PaperQuestionMapper;
import com.chaoxing.osm.service.test.IpaperService;
import com.chaoxing.osm.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName PaperServiceImpl
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-09
 */
@Service("ipaperService")
public class PaperServiceImpl implements IpaperService {
    @Autowired
    private PaperMapper paperMapper;
    @Autowired
    private PaperQuestionMapper questionMapper;
    @Autowired
    private PaperMarkMapper markMapper;
    @Autowired
    private PaperLogMapper paperLogMapper;

    @Override
    public ServerResponse<List<Paper>> foreList(String uuid) {
        List<Paper> list = paperMapper.selectForeList(uuid);
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse<List<Paper>> list(String uuid) {
        List<Paper> list = paperMapper.selectList(uuid);
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse<String> add(Paper paper) {
        paper.setInsertTime(new Date());
        paper.setIsDelete(ResponseString.UN_DELETE);
        // 模认设置下架
        paper.setStatus(ResponseString.IS_DELETE);
        paperMapper.insert(paper);
        return ServerResponse.createBySuccessMessage(ResponseString.ADD_SUCCESS);
    }

    @Override
    public ServerResponse<String> deleteById(Integer id) {
        Paper paper = paperMapper.selectByPrimaryKey(id);
        paper.setIsDelete(ResponseString.IS_DELETE);
        paper.setUpdateTime(new Date());
        paperMapper.updateByPrimaryKeySelective(paper);
        return ServerResponse.createBySuccessMessage(ResponseString.UPDATE_SUCCESS);
    }

    @Override
    public ServerResponse<String> update(Paper paper) {
        paper.setUpdateTime(new Date());
        paperMapper.updateByPrimaryKeySelective(paper);
        return ServerResponse.createBySuccessMessage(ResponseString.UPDATE_SUCCESS);
    }


    @Override
    public ServerResponse<String> finishJob(PaperDTO paperDTO) {

        //判断是否答过该试卷
        PaperMark res = markMapper.selectByPaperIdAndUserId(paperDTO.getPaperId(),paperDTO.getUserId());
        if(res!=null){
            return ServerResponse.createByErrorMessage("您已经答过本试卷了");
        }
        //判断是否在规定时间内答题
        String examTime = paperMapper.selectByPrimaryKey(paperDTO.getPaperId()).getExamtime();
        if(examTime!=null){
            try {
                int inTime = Integer.parseInt(examTime);
                int currentTime = DateUtil.getMinutes(paperDTO.getEndTime(),paperDTO.getStartTime());
                if(currentTime>inTime){
                    return ServerResponse.createByErrorMessage("超过规定时间答卷考试作废 请重新答卷");
                }
            }catch (NumberFormatException e) {

            }

        }
        int seconds = DateUtil.getSeconds(paperDTO.getEndTime(),paperDTO.getStartTime());
        // 记录考试成绩
        PaperMark mark = new PaperMark();
        mark.setTestPaperId(paperDTO.getPaperId());
        mark.setWxUserId(paperDTO.getUserId());
        mark.setCostTime(seconds);
        //分数
        int sum=0;
        List<AnswerDTO> list = paperDTO.getAnswers();
        for(int i=0;i<list.size();i++){
            // 记录答题日志
            PaperLog  pLog = new PaperLog();
            pLog.setUserId(paperDTO.getUserId());
            pLog.setPaperId(paperDTO.getPaperId());
            AnswerDTO dto = list.get(i);
            Integer questionId =dto.getQuestionId();
            pLog.setQuestionId(questionId);
            pLog.setAnswerType(Integer.parseInt(list.get(i).getType()));
            if(null!=dto.getAnswerId()){
                pLog.setAnswerId(dto.getAnswerId());
            }
            pLog.setAnswerDetail(dto.getAnswerDetail());
            if(StringUtils.isNotBlank(dto.getType()) &&"1".equals(dto.getType())){
                //主观题
            }else {
                // 统分
                PaperQuestion question = questionMapper.selectByPrimaryKey(questionId);
                if(question.getAnswer().equalsIgnoreCase(dto.getAnswerId()+"")){
                    sum+=question.getPoint();
                }
            }
            paperLogMapper.insert(pLog);
        }
        mark.setMark(sum);
        mark.setCreateTime(new Date());
        markMapper.insert(mark);
        return ServerResponse.createBySuccessMessage("提交试卷成功");
    }

    @Override
    public ServerResponse<String> status(Integer id) {

        Paper paper = paperMapper.selectByPrimaryKey(id);
        if(paper== null){
            return ServerResponse.createByErrorMessage(ResponseString.PARAMS_IS_EMPTY);
        }
        if(ResponseString.IS_DELETE.equals(paper.getStatus())){
            paper.setStatus(ResponseString.UN_DELETE);
        }else {
            paper.setStatus(ResponseString.IS_DELETE);
        }
        paper.setUpdateTime(new Date());
        paperMapper.updateByPrimaryKeySelective(paper);
        return ServerResponse.createBySuccessMessage(ResponseString.UPDATE_SUCCESS);
    }
}
