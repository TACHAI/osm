package com.chaoxing.osm.dao.vote;

import com.chaoxing.osm.bean.po.vote.Vote;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Vote record);

    int insertSelective(Vote record);

    Vote selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Vote record);

    int updateByPrimaryKey(Vote record);

    List<Vote> selectList(@Param("uuid")String uuid);

}