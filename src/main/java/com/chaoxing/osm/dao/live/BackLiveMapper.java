package com.chaoxing.osm.dao.live;

import com.chaoxing.osm.bean.po.live.BackLive;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BackLiveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BackLive record);

    int insertSelective(BackLive record);

    BackLive selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BackLive record);

    int updateByPrimaryKey(BackLive record);

    List<BackLive> selectList(@Param("liveName") String liveName,@Param("uuid")String uuid);

}