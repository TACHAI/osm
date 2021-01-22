package com.chaoxing.osm.dao.live;

import com.chaoxing.osm.bean.po.live.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Good record);

    int insertSelective(Good record);

    Good selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);

    Good selectByUserIdAndLiveId(@Param("userId") Integer userId, @Param("liveId") Integer liveId);

    List<Good> selectGoogByUserId(@Param("userId")String userId);

    List<Good> selectGoogByLiveId(@Param("liveId")Integer liveId);
}