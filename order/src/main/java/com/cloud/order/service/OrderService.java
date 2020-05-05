package com.cloud.order.service;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/8 16:22
 * @description:
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param userId        用户ID
     * @param commodityCode 商品码
     * @param count         订单金额
     */
    void create(String userId, String commodityCode, Integer count);
}
