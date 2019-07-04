package com.cloud.api.service;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/15 10:35
 * @description:
 */
public interface StorageService {

    void deduct(String commodityCode, int count);
}
