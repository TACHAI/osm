package com.chaoxing.osm.bean.vo.test;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName PaperVO
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-14 9:15
 */
@Data
public class PaperVO {
    /**
     * 试卷id
     */
    @NotNull
    @ApiModelProperty("试卷id")
    private Integer paperId;

    /**
     * 试卷名称
     */
    @NotEmpty
    @ApiModelProperty("试卷名")
    private String name;
    /**
     * 作者
     */
    @ApiModelProperty("作者")
    private String auther;
    /**
     * 介绍
     */
    @ApiModelProperty("介绍")
    private String introduction;

    /**
     * 考试时间
     */
    @ApiModelProperty("考试时间 单位是分钟")
    private String examtime;

    private List<PaperQuestionVO> questions;
}

