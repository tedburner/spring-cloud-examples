package com.cloud.order.service.impl;

import com.cloud.order.repository.OrderRepository;
import com.cloud.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/8 16:22
 * @description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public UserDO findUserById(Long id) {
        return userMapper.selectById(id);
    }
}
