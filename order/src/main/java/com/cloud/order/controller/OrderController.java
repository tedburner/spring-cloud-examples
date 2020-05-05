package com.cloud.order.controller;

import com.cloud.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/8 16:20
 * @description:
 */
@Slf4j
@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/create")
    public Boolean create(String userId, String commodityCode, Integer count) {
        log.info("用户【{}】创建订单", userId);
        orderService.create(userId, commodityCode, count);
        return true;
    }
}
