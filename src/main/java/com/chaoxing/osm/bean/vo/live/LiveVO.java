package com.chaoxing.osm.bean.vo.live;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName LiveVO
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-14 9:10
 */
@Data
public class LiveVO {

    /**
     * 新增直播id
     */
    @ApiModelProperty("直播id")
    private Integer id;
    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;
    /**
     * 封面图
     */
    @ApiModelProperty("封面图")
    private String cover;
    /**
     * 是否回放 0是回放  1是不回放
     */
    @ApiModelProperty("是否回放 0是回放  1是不回放")
    private Integer replay;
    /**
     * 作者
     */
    @ApiModelProperty("作者")
    private String auther;
    /**
     * 视频
     */
    @ApiModelProperty("视频")
    private String video;
    /**
     * 介绍
     */
    @ApiModelProperty("介绍")
    private String introduction;
    /**
     * 地点
     */
    @ApiModelProperty("地点")
    private String address;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;
    /**
     * 0是未删除 1是已删除
     */
    @ApiModelProperty("0是未删除 1是已删除")
    private Integer isDelete;
    /**
     * 播放次数
     */
    @ApiModelProperty("播放次数")
    private Integer pv;
    /**
     * 点赞数
     */
    @ApiModelProperty("点赞数")
    private Integer good;


    @ApiModelProperty("直播状态0未直播1是直播中2是直播完")
    private Integer status;


    /**
     * m3u8拉流地址
     */
    @ApiModelProperty("m3u8拉流地址")
    private String m3u8PullAddress;

    /**
     *  mp4直播文件下载地址
     */
    @ApiModelProperty("mp4直播文件下载地址")
    private String mp4Address;
    /**
     * m3u8文件下载地址
     */
    @ApiModelProperty("m3u8文件下载地址")
    private String m3u8Address;
}
