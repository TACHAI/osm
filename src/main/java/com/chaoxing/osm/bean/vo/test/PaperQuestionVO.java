package com.chaoxing.osm.bean.vo.test;

import com.chaoxing.osm.bean.po.test.PaperAnswer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

/**
 * @ClassName PaperQuestionVO
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-14 9:15
 */
@Data
public class PaperQuestionVO {
    /**
     * id
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 试卷问题
     */
    @NotEmpty
    @ApiModelProperty("试卷问题")
    private String questionName;
    /**
     * 答案详情
     */
    @ApiModelProperty("答案详情")
    private String answerDetail;
    /**
     * 答案选项
     */
    @ApiModelProperty("答案选择")
    private String answer;
    /**
     * 分数
     */
    @ApiModelProperty("分数")
    private Integer point;
    /**
     * 题目类型 冗余字段
     */
    @ApiModelProperty("题目类型 冗余字段")
    private String type;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("答案列表")
    private List<PaperAnswer> answers;

    @ApiModelProperty("正确答题")
    private String realAnswer;
}

