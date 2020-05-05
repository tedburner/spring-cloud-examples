package com.cloud.storage.controller;

import com.cloud.storage.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/15 10:26
 * @description: 商品库存模块
 */
@Slf4j
@RestController
public class StorageController {

    private final StorageService storageService;

    @Autowired
    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping(path = "/deduct")
    public Boolean deduct(String commodityCode, Integer count) {
        log.info("商品[{}]库存扣除：{}", commodityCode, count);
        storageService.deduct(commodityCode, count);
        return true;
    }
}
