package com.chaoxing.osm.bean.vo;

import lombok.Data;

/**
 * @ClassName PageVO
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-14 9:09
 */
@Data
public class PageVO<T> {
    /**
     * 总数
     */
    private Long total;
    /**
     * 数据
     */
    private T rows;
}