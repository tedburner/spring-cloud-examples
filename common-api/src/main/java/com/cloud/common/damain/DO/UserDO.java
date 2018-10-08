package com.cloud.common.damain.DO;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/8 16:14
 * @description:
 */
@Data
public class UserDO {

    private Long id;

    private String name;

    private Integer age;

    private String password;

    private String phone;

    private String card;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
