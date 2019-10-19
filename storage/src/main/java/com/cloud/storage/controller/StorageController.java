package com.cloud.storage.controller;

import com.cloud.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/15 10:26
 * @description:
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @GetMapping(path = "/deduct")
    public Boolean deduct(String commodityCode, Integer count) {
        storageService.deduct(commodityCode, count);
        return true;
    }
}
