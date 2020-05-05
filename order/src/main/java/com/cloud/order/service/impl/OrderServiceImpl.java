package com.cloud.order.service.impl;

import com.cloud.order.damain.Order;
import com.cloud.order.feign.UserFeignClient;
import com.cloud.order.repository.OrderRepository;
import com.cloud.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/8 16:22
 * @description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserFeignClient userFeignClient;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserFeignClient userFeignClient) {
        this.orderRepository = orderRepository;
        this.userFeignClient = userFeignClient;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(String userId, String commodityCode, Integer count) {
        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));

        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(count);
        order.setMoney(orderMoney);

        orderRepository.save(order);
        //远程调用，扣除款项
        userFeignClient.debit(userId, orderMoney);
    }
}
