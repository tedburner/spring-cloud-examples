package com.cloud.order.config;

import com.cloud.common.constant.MqConstant;
import com.cloud.order.service.OrderService;
import com.cloud.order.service.impl.TransactionListenerImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: lingjun.jlj
 * @date: 2020/12/16 20:03
 * @description:
 */
@Slf4j
@Component
public class TransactionProducer {

    /**
     * 需要自定义事务监听器 用于 事务的二次确认 和 事务回查
     */
    private TransactionListener transactionListener;

    /**
     * 这里的生产者和之前的不一样
     */
    private TransactionMQProducer producer = null;

    /**
     * 官方建议自定义线程 给线程取自定义名称 发现问题更好排查
     */
    private ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(2000), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("client-transaction-msg-check-thread");
            return thread;
        }

    });

    public TransactionProducer(@Autowired OrderService orderService) {
        transactionListener = new TransactionListenerImpl(orderService);
        // 初始化 事务生产者
        producer = new TransactionMQProducer(MqConstant.ORDER_TOPIC);
        // 添加服务器地址
        producer.setNamesrvAddr(MqConstant.NAME_SERVER);
        // 添加事务监听器
        producer.setTransactionListener(transactionListener);
        // 添加自定义线程池
        producer.setExecutorService(executorService);
        start();
    }

    public TransactionMQProducer getProducer() {
        return this.producer;
    }

    /**
     * 对象在使用之前必须要调用一次，只能初始化一次
     */
    public void start() {
        try {
            this.producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    /**
     * 一般在应用上下文，使用上下文监听器，进行关闭
     */
    public void shutdown() {
        this.producer.shutdown();
    }
}
