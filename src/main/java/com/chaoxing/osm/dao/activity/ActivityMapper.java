package com.chaoxing.osm.dao.activity;
import	java.lang.reflect.Parameter;

import com.chaoxing.osm.bean.po.activity.Activity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

    List<Activity> selectList(@Param("uuid") String uuid);

}