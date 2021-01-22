package com.chaoxing.osm.service.test.impl;

import com.chaoxing.osm.bean.po.test.Paper;
import com.chaoxing.osm.bean.po.test.PaperAnswer;
import com.chaoxing.osm.bean.po.test.PaperQuestion;
import com.chaoxing.osm.bean.vo.test.PaperQuestionVO;
import com.chaoxing.osm.bean.vo.test.PaperVO;
import com.chaoxing.osm.common.ResponseString;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.dao.test.PaperAnswerMapper;
import com.chaoxing.osm.dao.test.PaperMapper;
import com.chaoxing.osm.dao.test.PaperQuestionMapper;
import com.chaoxing.osm.service.test.IpaperQuestionService;
import com.chaoxing.osm.utils.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName PaperQuestionServiceImpl
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-09
 */
@Slf4j
@Service("ipaperQuestionService")
public class PaperQuestionServiceImpl implements IpaperQuestionService {
    @Autowired
    private PaperQuestionMapper paperQuestionMapper;
    @Autowired
    private PaperAnswerMapper paperAnswerMapper;
    @Autowired
    private PaperMapper paperMapper;

    @Override
    public ServerResponse<List<PaperQuestion>> listByPaperId(Integer paperId) {
        List<PaperQuestion> list = paperQuestionMapper.slectByPaperId(paperId);
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse<String> add(PaperQuestion paperQuestion) {
        paperQuestion.setCreateTime(new Date());
        if(StringUtils.isBlank(paperQuestion.getType())){
            paperQuestion.setType(ResponseString.UN_DELETE+"");
        }
        paperQuestion.setIsDelete(ResponseString.UN_DELETE);
        paperQuestionMapper.insert(paperQuestion);
        return ServerResponse.createBySuccessMessage(ResponseString.ADD_SUCCESS);
    }

    @Override
    public ServerResponse<String> delete(Integer id) {
        PaperQuestion paperQuestion = paperQuestionMapper.selectByPrimaryKey(id);
        paperQuestion.setIsDelete(ResponseString.IS_DELETE);
        paperQuestion.setUpdateTime(new Date());
        paperQuestionMapper.updateByPrimaryKeySelective(paperQuestion);
        return ServerResponse.createBySuccessMessage(ResponseString.DELETE_SUCCESS);
    }

    @Override
    public ServerResponse<String> update(PaperQuestion paperQuestion) {
        paperQuestion.setUpdateTime(new Date());
        paperQuestionMapper.updateByPrimaryKeySelective(paperQuestion);
        return ServerResponse.createBySuccessMessage(ResponseString.UPDATE_SUCCESS);
    }

    @Override
    public ServerResponse<PaperVO> listQuestionByPaperId(Integer paperId) {
        PaperVO paperVo = new PaperVO();
        Paper pager = paperMapper.selectByPrimaryKey(paperId);
        paperVo.setPaperId(paperId);
        paperVo.setAuther(pager.getAuther());
        paperVo.setIntroduction(pager.getIntroduction());
        paperVo.setExamtime(pager.getExamtime());
        paperVo.setName(pager.getName());

        List< PaperQuestionVO> voList = new ArrayList<> ();
        List<PaperQuestion> list = paperQuestionMapper.slectByPaperId(paperId);
        list.forEach(e->{
            List<PaperAnswer> answers = paperAnswerMapper.selectByQuestionId(e.getId());
            PaperQuestionVO vo =new PaperQuestionVO();
            BeanUtils.copyProperties(e,vo);
            vo.setAnswers(answers);
            voList.add(vo);
        });
        paperVo.setQuestions(voList);
        return ServerResponse.createBySuccess(paperVo);
    }

    @Override
    public ServerResponse<String> importQuestion(Integer paperId, MultipartFile file) {
        // 读取excel
        if(file.isEmpty()){
            ServerResponse.createByErrorMessage(ResponseString.PARAMS_IS_EMPTY);
        }
        String[] heads={"序号","类型","题目","答案详解","正确答案","分数","答案一","答案二","答案三","答案四"};
        List list = null;
        try {
            list = read(file,heads);
        } catch (IOException e) {
            log.error("PaperQuestionServiceImpl-importQuestion:{}",e.getMessage());
            ServerResponse.createByErrorMessage("解析excel出错");
        }
        // 写数据
        if(list!=null){
            for(int i=0;i<list.size();i++){
                PaperQuestion paperQuestion = new PaperQuestion();
                paperQuestion.setPaperId(paperId);
                Map map = (Map) list.get(i);

                //类型  默认设置客观题
                if(StringUtils.isNotBlank((String) map.get(heads[1]))){
                    String type = (String)map.get(heads[1]);
                    paperQuestion.setType(type);
                }else {
                    paperQuestion.setType(ResponseString.UN_DELETE+"");
                }


                String question = (String) map.get(heads[2]);
                // 题目
                if(StringUtils.isNotBlank(question)){
                    paperQuestion.setQuestionName(question);
                    if(paperQuestionMapper.selectByPaperIdAndQuestionName(paperId,question)!=null){
                        continue;
                    }
                }else {
                    continue;
                }
                // 答案详解
                String answerDetail = (String) map.get(heads[3]);
                if(StringUtils.isNotBlank(answerDetail)){
                    paperQuestion.setAnswerDetail(answerDetail);
                }
                // 分数
                String point = (String) map.get(heads[5]);
                if(StringUtils.isNotBlank(point)){
                    paperQuestion.setPoint(Integer.parseInt(point.trim()));
                }
                paperQuestion.setCreateTime(new Date());
                paperQuestion.setIsDelete(ResponseString.UN_DELETE);
                // 插入问题
                paperQuestionMapper.insert(paperQuestion);

                // 插入答案
                List answers =new ArrayList();
                String answer1 = (String) map.get(heads[6]);
                if(StringUtils.isNotBlank(answer1)){
                    answers.add(answer1);
                }
                String answer2 = (String) map.get(heads[7]);
                if(StringUtils.isNotBlank(answer2)){
                    answers.add(answer2);
                }
                String answer3 = (String) map.get(heads[8]);
                if(StringUtils.isNotBlank(answer3)){
                    answers.add(answer3);
                }
                String answer4 = (String) map.get(heads[9]);
                if(StringUtils.isNotBlank(answer4)){
                    answers.add(answer4);
                }
                int[] answerIds = new int[answers.size()];
                for(int j=0;j<answers.size(); j++){
                    PaperAnswer paperAnswer = new PaperAnswer();
                    paperAnswer.setQuestionId(paperQuestion.getId());
                    paperAnswer.setCreateTime(new Date());
                    paperAnswer.setAnswer((String) answers.get(j));
                    paperAnswerMapper.insert(paperAnswer);
                    answerIds[j]=paperAnswer.getId();
                }
                // 问题中插入答案id
                String reallyAnswer = (String) map.get(heads[4]);
                if(StringUtils.isNotBlank(reallyAnswer)){
                    String answerId = answerIds[Integer.parseInt(reallyAnswer.trim())-1]+"";
                    paperQuestion.setAnswer(answerId);
                    paperQuestionMapper.updateByPrimaryKeySelective(paperQuestion);
                }

            }
        }else {
            return ServerResponse.createByErrorMessage("数据导入失败");
        }
        return ServerResponse.createBySuccessMessage("数据导入成功");
    }

    public List read(MultipartFile file,String[] heads) throws IOException {
        Workbook wb = null;

        String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        InputStream input = file.getInputStream();
        if("xls".equals(fileType)){
            wb = new HSSFWorkbook(input);
        }else if("xlsx".equals(fileType)){
            wb = new XSSFWorkbook(input);
        }else {
           return null;
        }

     return ExcelUtils.readFileData(wb,heads);
    }
}
