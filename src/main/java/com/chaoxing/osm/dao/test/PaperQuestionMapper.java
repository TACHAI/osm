package com.chaoxing.osm.dao.test;

import com.chaoxing.osm.bean.po.test.PaperQuestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PaperQuestion record);

    int insertSelective(PaperQuestion record);

    PaperQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PaperQuestion record);

    int updateByPrimaryKey(PaperQuestion record);

    List<PaperQuestion> slectByPaperId(@Param("paperId") Integer paperId);

    PaperQuestion selectByPaperIdAndQuestionName(@Param("paperId")Integer paperId,@Param("questionName") String questionName);
}