package com.chaoxing.osm.dao.test;

import com.chaoxing.osm.bean.po.test.PaperLog;

import java.util.List;

public interface PaperLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PaperLog record);

    int insertSelective(PaperLog record);

    PaperLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PaperLog record);

    int updateByPrimaryKey(PaperLog record);

    List<PaperLog> getByUserIdAndPaperId(Integer userId, Integer paperId);

}