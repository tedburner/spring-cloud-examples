package com.cloud.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constant.Constant;
import com.cloud.order.config.TransactionProducer;
import com.cloud.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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
    private TransactionProducer transactionProducer;

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

    /**
     * 商品下单
     */
    @GetMapping(value = "save")
    public String save(String userId, String productId, Integer count) throws MQClientException {
        //通过uuid 当key
        String uuid = UUID.randomUUID().toString().replace("_", "");
        //封装消息
        JSONObject msgJson = new JSONObject();
        msgJson.put("userId", userId);
        msgJson.put("productId", productId);
        msgJson.put("count", count);
        String jsonString = msgJson.toJSONString();
        //封装消息实体
        Message message = new Message(Constant.ORDER_TOPIC, null, uuid, jsonString.getBytes());
        //发送消息 用 sendMessageInTransaction  第一个参数可以理解成消费方需要的参数 第二个参数可以理解成消费方不需要 本地事务需要的参数
        SendResult sendResult = transactionProducer.getProducer().sendMessageInTransaction(message, userId);
        System.out.printf("发送结果=%s, sendResult=%s \n", sendResult.getSendStatus(), sendResult.toString());

        if (SendStatus.SEND_OK == sendResult.getSendStatus()) {
            return "成功";
        }

        return "失败";
    }
}
