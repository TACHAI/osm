package com.chaoxing.osm.bean.vo.activity;

import com.chaoxing.osm.bean.po.activity.Activity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName ActivityVO
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-14 9:09
 */
@Data
public class ActivityVO extends Activity {
    /**
     *  活动id
     */
    @ApiModelProperty("活动id")
    private Integer id;
    /**
     * 活动标题
     */
    @ApiModelProperty("活动标题")
    private String title;
    /**
     * 作者
     */
    @ApiModelProperty("作者")
    private String auther;
    /**
     * 活动地址
     */
    @ApiModelProperty("活动地址")
    private String address;
    /**
     * 封面图
     */
    @ApiModelProperty("封面图")
    private String cover;
    /**
     * 活动时间
     */
    @ApiModelProperty("活动时间")
    private Date activitytime;
    /**
     * 组织部门
     */
    @ApiModelProperty("组织部门")
    private String organizer;
    /**
     * 详情
     */
    @ApiModelProperty("详情")
    private String detail;
    /**
     * 状态 0是上架 1是下架
     */
    @ApiModelProperty("状态 0是上架 1是下架")
    private String status;

    /**
     * 参与人数
     */
    @ApiModelProperty("参与人数 ")
    private Integer count;
}

