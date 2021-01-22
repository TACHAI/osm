package com.chaoxing.osm.service.test.impl;


import com.chaoxing.osm.bean.po.test.PaperAnswer;
import com.chaoxing.osm.common.ResponseString;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.dao.test.PaperAnswerMapper;
import com.chaoxing.osm.service.test.IpaperAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName PaperAnswerServieImpl
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-09
 */
@Service("ipaperAnswerService")
public class PaperAnswerServieImpl implements IpaperAnswerService {
    @Autowired
    private PaperAnswerMapper paperAnswerMapper;

    @Override
    public ServerResponse<List<PaperAnswer>> listByPaperQuestionId(Integer questionId) {
        List<PaperAnswer> list = paperAnswerMapper.selectByQuestionId(questionId);
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse<String> add(PaperAnswer paperAnswer) {
        paperAnswer.setCreateTime(new Date());
        paperAnswerMapper.insert(paperAnswer);
        return ServerResponse.createBySuccessMessage(ResponseString.ADD_SUCCESS);
    }

    @Override
    public ServerResponse<String> delete(Integer id) {
        paperAnswerMapper.deleteByPrimaryKey(id);
        return ServerResponse.createBySuccessMessage(ResponseString.DELETE_SUCCESS);
    }

    @Override
    public ServerResponse<String> update(PaperAnswer paperAnswer) {
        paperAnswerMapper.updateByPrimaryKeySelective(paperAnswer);
        return ServerResponse.createBySuccessMessage(ResponseString.UPDATE_SUCCESS);
    }
}
