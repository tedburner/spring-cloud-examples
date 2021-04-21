package com.cloud.business.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author: lingjun.jlj
 * @date: 2021/4/21 21:16
 * @description:
 */
@Slf4j
@Component
public class StorageHystrix{

    /**
     * 扣除仓储服务降级
     *
     * @param commodityCode 商品码
     * @param count         数量
     */
    public void deduct(String commodityCode, Integer count) {
        log.info("扣除商品数据失败，仓储服务降级");
    }
}
