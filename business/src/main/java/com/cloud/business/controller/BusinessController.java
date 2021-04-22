package com.cloud.business.controller;

import com.cloud.business.service.BusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lingjun.jlj
 * @description: 模拟业务流程
 */
@Slf4j
@RestController
public class BusinessController {

    private final BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    /**
     * 购买下单，模拟全局事务提交
     *
     * @return
     */
    @GetMapping(value = "/purchase/commit")
    public Boolean purchaseCommit(String userId, String commodityCode, Integer commodityCount) {
        log.info("购买下单，模拟全局事务提交");
        businessService.purchase(userId, commodityCode, commodityCount);
        return true;
    }

    /**
     * 购买下单，模拟全局事务回滚
     *
     * @return
     */
    @RequestMapping("/purchase/rollback")
    public Boolean purchaseRollback() {
        try {
            log.info("购买下单，模拟全局事务回滚");
            businessService.purchase("1002", "2001", 1);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
