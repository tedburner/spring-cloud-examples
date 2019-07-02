package com.cloud.common.damain.DO;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/8 16:14
 * @description:
 */
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String commodityCode;
    private BigDecimal money;
    private Integer count;
}
