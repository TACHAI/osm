package com.chaoxing.osm.dao.live;

import com.chaoxing.osm.bean.po.live.Live;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LiveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Live record);

    int insertSelective(Live record);

    Live selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Live record);

    int updateByPrimaryKey(Live record);

    List<Live> selectList(@Param("liveName") String liveName,@Param("uuid")String uuid);

    List<Live> selectListfore(@Param("liveName") String liveName,@Param("uuid")String uuid);
}