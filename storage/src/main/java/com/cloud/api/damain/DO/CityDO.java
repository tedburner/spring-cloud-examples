package com.cloud.api.damain.DO;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/15 10:29
 * @description:
 */

@Data
public class CityDO implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 城市编号
     */
    private Long id;

    /**
     * 省份编号
     */
    private Long provinceId;

    /**
     * 城市名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
