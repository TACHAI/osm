package com.chaoxing.osm.dao.test;

import com.chaoxing.osm.bean.po.test.Paper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Paper record);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);

    List<Paper> selectList(@Param("uuid")String uuid);

    List<Paper> selectForeList(@Param("uuid")String uuid);
}