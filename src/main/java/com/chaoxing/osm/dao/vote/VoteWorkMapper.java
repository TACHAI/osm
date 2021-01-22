package com.chaoxing.osm.dao.vote;

import com.chaoxing.osm.bean.po.vote.VoteWork;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoteWorkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VoteWork record);

    int insertSelective(VoteWork record);

    VoteWork selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VoteWork record);

    int updateByPrimaryKeyWithBLOBs(VoteWork record);

    int updateByPrimaryKey(VoteWork record);

    List<VoteWork> selectList(@Param("voteId") Integer voteId);

}