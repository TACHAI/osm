package com.chaoxing.osm.service.test.impl;

import com.chaoxing.osm.bean.po.test.PaperLog;
import com.chaoxing.osm.bean.vo.test.DonePaperVO;
import com.chaoxing.osm.bean.vo.test.PaperQuestionVO;
import com.chaoxing.osm.common.ResponseString;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.dao.test.*;
import com.chaoxing.osm.dao.user.WxUserMapper;
import com.chaoxing.osm.service.test.IPaperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PaperLogServiceImpl
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-12-04 10:14
 */
@Service("ipaperLogService")
public class PaperLogServiceImpl implements IPaperLogService {
    @Autowired
    private PaperLogMapper paperLogMapper;
    @Autowired
    private PaperMapper paperMapper;
    @Autowired
    private WxUserMapper wxUserMapper;
    @Autowired
    private PaperMarkMapper paperMarkMapper;
    @Autowired
    private PaperAnswerMapper paperAnswerMapper;
    @Autowired
    private PaperQuestionMapper paperQuestionMapper;

    @Override
    public ServerResponse<String> add(PaperLog log) {
        int res =  paperLogMapper.insert(log);
        if(res>0){
            return ServerResponse.createBySuccessMessage(ResponseString.ADD_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.ADD_FAIL);
    }

    @Override
    public ServerResponse<DonePaperVO> getByUserIdAndPaperId(Integer userId, Integer paperId) {
        DonePaperVO donePaper = new DonePaperVO();

        donePaper.setName( paperMapper.selectByPrimaryKey(paperId).getName());
        donePaper.setAuther(wxUserMapper.selectByPrimaryKey(userId).getPickname());
        donePaper.setMark(paperMarkMapper.selectByPaperIdAndUserId(paperId,userId).getMark());

        List<PaperLog> list = paperLogMapper.getByUserIdAndPaperId(userId,paperId);
        List<PaperQuestionVO>  questionVOS = new ArrayList<>();
        for(int i =0 ; i <list.size(); i++ ){
            PaperQuestionVO questionVO = new PaperQuestionVO();
            questionVO.setId(list.get(i).getQuestionId());
            questionVO.setAnswers(paperAnswerMapper.selectByQuestionId(list.get(i).getQuestionId()));
            questionVO.setType(list.get(i).getAnswerType()+"");
            questionVO.setAnswerDetail(list.get(i).getAnswerDetail());
            questionVO.setPoint(paperQuestionMapper.selectByPrimaryKey(list.get(i).getQuestionId()).getPoint());
            questionVO.setQuestionName(paperQuestionMapper.selectByPrimaryKey(list.get(i).getQuestionId()).getQuestionName());
            questionVO.setCreateTime(paperQuestionMapper.selectByPrimaryKey(list.get(i).getQuestionId()).getCreateTime());
            questionVO.setRealAnswer(paperQuestionMapper.selectByPrimaryKey(list.get(i).getQuestionId()).getAnswer());
            questionVOS.add(questionVO);
        }
        donePaper.setQuestionList(questionVOS);
        return ServerResponse.createBySuccess(donePaper);
    }
}
