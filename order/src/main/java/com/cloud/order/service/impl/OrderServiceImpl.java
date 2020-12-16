package com.cloud.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cloud.order.damain.Order;
import com.cloud.order.feign.UserFeignClient;
import com.cloud.order.repository.OrderRepository;
import com.cloud.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/8 16:22
 * @description:
 */
@Slf4j
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

    @Override
    public int save(String userId, String commodityCode, Integer count) {
        //下单之前肯定要 检查该商品是否存在 库存是否够
//        String response = produceClient.findById(produceId);
        //Json字符串转换成JsonNode对象
//        JSONObject jsonObject = JSONObject.parseObject(response);
//        Integer store = jsonObject.getInteger("store");
//        String produceName = jsonObject.getString("produceName");
//        if (store == null) {
//            log.info("找不到商品消息，商品ID = {}", produceId);
//            return 1;
//        }
//        log.info("商品存在,商品ID = {},商品当前库存 = {}", produceId, store, produceName);
//        // 如果实际库存小于库存
//        if (store - total < 0) {
//            log.info("库存不足，扣减失败。商品ID = {},商品当前库存 = {},所需库存 = {}，分布式事务key = {}", produceId, store, total);
//            return 1;
//        }

        log.info("===订单模块=== 本地事务执行成功,订单生成成功");
        return 0;
    }
}
