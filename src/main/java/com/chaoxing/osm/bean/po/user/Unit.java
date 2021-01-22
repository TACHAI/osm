package com.chaoxing.osm.bean.po.user;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class Unit {
    private Integer id;

    private Integer fid;

    private String unitUuid;

    private String unitName;

    private String unitWxAppid;

    private String unitWxKey;

    @ApiModelProperty("单位所有的应用分号隔开，如activity;live;test")
    private String unitApp;

    private String unitDetail;

    private Integer isDelete;

    private Date creatDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getUnitUuid() {
        return unitUuid;
    }

    public void setUnitUuid(String unitUuid) {
        this.unitUuid = unitUuid == null ? null : unitUuid.trim();
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public String getUnitWxAppid() {
        return unitWxAppid;
    }

    public void setUnitWxAppid(String unitWxAppid) {
        this.unitWxAppid = unitWxAppid == null ? null : unitWxAppid.trim();
    }

    public String getUnitWxKey() {
        return unitWxKey;
    }

    public void setUnitWxKey(String unitWxKey) {
        this.unitWxKey = unitWxKey == null ? null : unitWxKey.trim();
    }

    public String getUnitApp() {
        return unitApp;
    }

    public void setUnitApp(String unitApp) {
        this.unitApp = unitApp == null ? null : unitApp.trim();
    }

    public String getUnitDetail() {
        return unitDetail;
    }

    public void setUnitDetail(String unitDetail) {
        this.unitDetail = unitDetail == null ? null : unitDetail.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }
}