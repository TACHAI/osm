package com.chaoxing.osm.bean.vo.test;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotEmpty;

import java.util.List;

/**
 * @ClassName DonePaperVO
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-14 9:11
 */
@Data
public class DonePaperVO {

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
     * 成绩
     */
    @ApiModelProperty("成绩")
    private Integer mark;

    /**
     * 题目列表
     */
    @ApiModelProperty("题目列表")
    private List<PaperQuestionVO> questionList;
}

