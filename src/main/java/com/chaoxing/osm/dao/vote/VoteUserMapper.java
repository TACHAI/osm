package com.chaoxing.osm.dao.vote;

import com.chaoxing.osm.bean.po.vote.VoteUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoteUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VoteUser record);

    int insertSelective(VoteUser record);

    VoteUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VoteUser record);

    int updateByPrimaryKey(VoteUser record);

    List<VoteUser> selectListByVoteId(@Param("voteId") Integer voteId);

    VoteUser selectByVoteIdAndUserId(@Param("voteId") Integer voteId, @Param("userId") Integer userId);
}