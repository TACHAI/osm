package com.chaoxing.osm.dao.test;

import com.chaoxing.osm.bean.dto.test.PaperMarkDTO;
import com.chaoxing.osm.bean.po.test.PaperMark;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperMarkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PaperMark record);

    int insertSelective(PaperMark record);

    PaperMark selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PaperMark record);

    int updateByPrimaryKey(PaperMark record);

    List<PaperMarkDTO> selectByPaperId(Integer paperId);

    PaperMark selectByPaperIdAndUserId(@Param("paperId") Integer paperId, @Param("userId") Integer userId);

    List<PaperMarkDTO> selectOrderByPaperId(Integer paperId);
}