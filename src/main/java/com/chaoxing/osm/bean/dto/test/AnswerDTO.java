package com.chaoxing.osm.bean.dto.test;

import lombok.Data;

/**
 * @ClassName AnswerDTO
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-27 10:37
 */
@Data
public class AnswerDTO {
    private Integer questionId;
    private Integer answerId;
    // add by TACHI 2020-12-04
    // 0是客观题 1是主观题
    private String type;
    private String answerDetail;
}
