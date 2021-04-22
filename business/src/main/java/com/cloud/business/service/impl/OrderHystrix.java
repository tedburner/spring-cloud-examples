package com.cloud.business.service.impl;

import com.cloud.business.feign.OrderFeignClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: lingjun.jlj
 * @date: 2021/4/21 21:20
 * @description:
 */
@Slf4j
@Component
public class OrderHystrix implements FallbackFactory<OrderFeignClient> {

    @Override
    public OrderFeignClient create(Throwable throwable) {
        return new OrderFeignClient() {
            @Override
            public void create(String userId, String commodityCode, Integer count) {
                log.error("创建订单失败，进行服务降级");
            }
        };
    }
}
