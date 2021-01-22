package com.chaoxing.osm.bean.po.vote;

import java.util.Date;

public class VoteUser {
    private Integer id;

    private Integer userId;

    private Integer voteId;

    private Integer voteWorkId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public Integer getVoteWorkId() {
        return voteWorkId;
    }

    public void setVoteWorkId(Integer voteWorkId) {
        this.voteWorkId = voteWorkId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}