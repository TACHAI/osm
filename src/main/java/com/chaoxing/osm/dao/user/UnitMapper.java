package com.chaoxing.osm.dao.user;

import com.chaoxing.osm.bean.po.user.Unit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UnitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Unit record);

    int insertSelective(Unit record);

    Unit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);

    int deleteByUUID(@Param("uuid") String uuid);

    List<Unit> selectByName(@Param("unitName") String name);

    Unit selectByUUID(@Param("unitUuid") String uuid);

    List<Unit> selectAll(@Param("unitName") String unitName);
}