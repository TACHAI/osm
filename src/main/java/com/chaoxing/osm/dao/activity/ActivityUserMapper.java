package com.chaoxing.osm.dao.activity;

import com.chaoxing.osm.bean.po.activity.ActivityUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ActivityUser record);

    int insertSelective(ActivityUser record);

    ActivityUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActivityUser record);

    int updateByPrimaryKey(ActivityUser record);

    List<ActivityUser> selectList(Integer activityId);

    ActivityUser selectByPhone(@Param("activityId") Integer activityId, @Param("phone") String phone);

}