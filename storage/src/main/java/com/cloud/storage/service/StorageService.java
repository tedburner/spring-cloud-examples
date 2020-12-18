package com.cloud.storage.service;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/15 10:35
 * @description:
 */
public interface StorageService {

    /**
     * 扣库存
     *
     * @param commodityCode
     * @param count
     */
    void deduct(String commodityCode, int count);

    /**
     * 扣库存
     *
     * @param commodityCode 商品code
     * @param count         商品数量
     * @param txKey         事务key
     */
    void deduct(String commodityCode, int count, String txKey);

    /**
     * 查询商品库存
     *
     * @param commodityCode
     * @return
     */
    Integer findById(String commodityCode);
}
