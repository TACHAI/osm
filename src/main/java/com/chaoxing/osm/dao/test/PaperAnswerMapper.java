package com.chaoxing.osm.dao.test;

import com.chaoxing.osm.bean.po.test.PaperAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperAnswerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PaperAnswer record);

    int insertSelective(PaperAnswer record);

    PaperAnswer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PaperAnswer record);

    int updateByPrimaryKey(PaperAnswer record);

    List<PaperAnswer> selectByQuestionId(@Param("questionId") Integer questionId);

}