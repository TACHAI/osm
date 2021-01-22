package com.chaoxing.osm.bean.po.vote;

import java.util.Date;

public class Vote {
    private Integer id;

    private String name;

    private String introduction;

    private String cover;

    private String organizer;

    private Integer status;

    private String votetime;

    private Date createTime;

    private Date updateTime;

    private Integer isDelete;

    private Date vstartTime;

    private Date vendTime;

    private Date ustartTime;

    private Date uendTime;

    private String unitUuid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer == null ? null : organizer.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getVotetime() {
        return votetime;
    }

    public void setVotetime(String votetime) {
        this.votetime = votetime == null ? null : votetime.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getVstartTime() {
        return vstartTime;
    }

    public void setVstartTime(Date vstartTime) {
        this.vstartTime = vstartTime;
    }

    public Date getVendTime() {
        return vendTime;
    }

    public void setVendTime(Date vendTime) {
        this.vendTime = vendTime;
    }

    public Date getUstartTime() {
        return ustartTime;
    }

    public void setUstartTime(Date ustartTime) {
        this.ustartTime = ustartTime;
    }

    public Date getUendTime() {
        return uendTime;
    }

    public void setUendTime(Date uendTime) {
        this.uendTime = uendTime;
    }

    public String getUnitUuid() {
        return unitUuid;
    }

    public void setUnitUuid(String unitUuid) {
        this.unitUuid = unitUuid == null ? null : unitUuid.trim();
    }
}