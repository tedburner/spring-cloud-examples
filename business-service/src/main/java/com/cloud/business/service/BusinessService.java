package com.cloud.business.service;

/**
 * @author: lingjun.jlj
 * @date: 2019/7/3 14:54
 * @version：1.0
 * @description:
 */
public interface BusinessService {

    /**
     * 减库存，下订单
     *
     * @param userId
     * @param commodityCode
     * @param commodityCount
     */
    void purchase(String userId, String commodityCode, int commodityCount);
}
