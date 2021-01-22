package com.chaoxing.osm.bean.vo.test;

import com.chaoxing.osm.bean.dto.test.PaperMarkDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName PaperMarkVO
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-14 9:14
 */
@Data
public class PaperMarkVO {
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;
    /**
     * 成绩
     */
    @ApiModelProperty("成绩")
    private Integer mark;

    @ApiModelProperty("头像")
    private String headimgurl;

    /**
     * 前10成绩
     */
    @ApiModelProperty("前10成绩")
    private List<PaperMarkDTO> data;
}

