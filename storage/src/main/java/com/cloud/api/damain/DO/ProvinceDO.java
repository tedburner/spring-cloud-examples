package com.cloud.api.damain.DO;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lingjun.jlj
 * @date 2017/12/2
 */
@Data
public class ProvinceDO {
    private Long id;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
