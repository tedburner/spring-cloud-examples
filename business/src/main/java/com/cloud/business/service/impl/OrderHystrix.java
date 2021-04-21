package com.cloud.business.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author: lingjun.jlj
 * @date: 2021/4/21 21:20
 * @description:
 */
@Slf4j
@Component
public class OrderHystrix {

    /**
     * 创建订单——进行服务降级
     *
     * @param userId        用户
     * @param commodityCode 商品code
     * @param count         购买数量
     */
    public void create(String userId, String commodityCode, Integer count) {
        log.error("创建订单失败，进行服务降级");
    }
}
