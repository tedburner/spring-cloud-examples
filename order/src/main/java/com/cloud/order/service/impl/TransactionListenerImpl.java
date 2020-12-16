package com.cloud.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cloud.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: lingjun.jlj
 * @date: 2020/12/16 20:04
 * @description:
 */
@Slf4j
public class TransactionListenerImpl implements TransactionListener {

    private final OrderService orderService;

    @Autowired
    public TransactionListenerImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object object) {
        log.info("=========本地事务开始执行=============");
        String message = new String(msg.getBody());
        JSONObject jsonObject = JSONObject.parseObject(message);
        String productId = jsonObject.getString("productId");
        Integer total = jsonObject.getInteger("total");
        String userId = object.toString();
        //模拟执行本地事务begin=======
        /**
         * 本地事务执行会有三种可能
         * 1、commit 成功
         * 2、Rollback 失败
         * 3、网络等原因服务宕机收不到返回结果
         */
        log.info("本地事务执行参数,用户id={},商品ID={},销售库存={}", userId, productId, total);
        int result = orderService.save(userId, productId, total);
        //模拟执行本地事务end========
        //TODO 实际开发下面不需要我们手动返回，而是根据本地事务执行结果自动返回
        //1、二次确认消息，然后消费者可以消费
        if (result == 0) {
            return LocalTransactionState.COMMIT_MESSAGE;
        }
        //2、回滚消息，Broker端会删除半消息
        if (result == 1) {
            return LocalTransactionState.ROLLBACK_MESSAGE;
        }
        //3、Broker端会进行回查消息
        if (result == 2) {
            return LocalTransactionState.UNKNOW;
        }
        return LocalTransactionState.COMMIT_MESSAGE;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        return null;
    }
}
