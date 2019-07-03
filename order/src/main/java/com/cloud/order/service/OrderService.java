package com.cloud.order.service;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/8 16:22
 * @description:
 */
public interface OrderService {

    void create(String userId, String commodityCode, Integer count);
}
