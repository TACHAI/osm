package com.chaoxing.osm.bean.po.live;

import java.util.Date;

public class BackLive {
    private Integer id;

    private String title;

    private String introduction;

    private String address;

    private Integer replay;

    private String videoStreamName;

    private String pullStreamAddress;

    private String rtmpPullAddress;

    private String m3u8PullAddress;

    private String stramId;

    private String pushStramAddress;

    private String fileAddress;

    private String mp4Address;

    private String m3u8Address;

    private Date noticeTime;

    private Date createTime;

    private Date updateTime;

    private Integer isDelete;

    private String unitUuid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getReplay() {
        return replay;
    }

    public void setReplay(Integer replay) {
        this.replay = replay;
    }

    public String getVideoStreamName() {
        return videoStreamName;
    }

    public void setVideoStreamName(String videoStreamName) {
        this.videoStreamName = videoStreamName == null ? null : videoStreamName.trim();
    }

    public String getPullStreamAddress() {
        return pullStreamAddress;
    }

    public void setPullStreamAddress(String pullStreamAddress) {
        this.pullStreamAddress = pullStreamAddress == null ? null : pullStreamAddress.trim();
    }

    public String getRtmpPullAddress() {
        return rtmpPullAddress;
    }

    public void setRtmpPullAddress(String rtmpPullAddress) {
        this.rtmpPullAddress = rtmpPullAddress == null ? null : rtmpPullAddress.trim();
    }

    public String getM3u8PullAddress() {
        return m3u8PullAddress;
    }

    public void setM3u8PullAddress(String m3u8PullAddress) {
        this.m3u8PullAddress = m3u8PullAddress == null ? null : m3u8PullAddress.trim();
    }

    public String getStramId() {
        return stramId;
    }

    public void setStramId(String stramId) {
        this.stramId = stramId == null ? null : stramId.trim();
    }

    public String getPushStramAddress() {
        return pushStramAddress;
    }

    public void setPushStramAddress(String pushStramAddress) {
        this.pushStramAddress = pushStramAddress == null ? null : pushStramAddress.trim();
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress == null ? null : fileAddress.trim();
    }

    public String getMp4Address() {
        return mp4Address;
    }

    public void setMp4Address(String mp4Address) {
        this.mp4Address = mp4Address == null ? null : mp4Address.trim();
    }

    public String getM3u8Address() {
        return m3u8Address;
    }

    public void setM3u8Address(String m3u8Address) {
        this.m3u8Address = m3u8Address == null ? null : m3u8Address.trim();
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
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

    public String getUnitUuid() {
        return unitUuid;
    }

    public void setUnitUuid(String unitUuid) {
        this.unitUuid = unitUuid == null ? null : unitUuid.trim();
    }
}