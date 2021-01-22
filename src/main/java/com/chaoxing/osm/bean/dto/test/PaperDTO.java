package com.chaoxing.osm.bean.dto.test;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @ClassName PaperDTO
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-27 10:35
 */
@Data
public class PaperDTO {
    @NotNull
    @ApiModelProperty("试卷id")
    private Integer paperId;
    @NotNull
    @ApiModelProperty("用户id")
    private Integer userId;
    @ApiModelProperty("答案对象")
    private List<AnswerDTO> answers;
    @ApiModelProperty("答题开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @ApiModelProperty("答题结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
