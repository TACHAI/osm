package com.chaoxing.osm.bean.dto.test;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName PaperMarkDTO
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-09
 */
@Data
public class PaperMarkDTO {

    @ApiModelProperty("id")
    private Integer id;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer wxUserId;
    /**
     * 试卷id
     */
    @ApiModelProperty("试卷id")
    private Integer testPaperId;

    /**
     * 试卷名
     */
    @ApiModelProperty("试卷名")
    private String paperName;

    @ApiModelProperty("昵称")
    private String pickname;

    /**
     * 分数成绩
     */
    @ApiModelProperty("分数成绩")
    private Integer mark;

    @ApiModelProperty("头像")
    private String headimgurl;

   @ApiModelProperty("生成时间")
    private Date createTime;

    /**
     * 耗时
     */
    @ApiModelProperty("耗时")
    private Integer costTime;
}
