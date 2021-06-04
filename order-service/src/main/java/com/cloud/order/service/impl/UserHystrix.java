package com.cloud.order.service.impl;

import com.cloud.order.feign.UserFeignClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author: lingjun.jlj
 * @date: 2021/4/21 21:01
 * @description:
 */
@Slf4j
@Component
public class UserHystrix implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public Boolean debit(String userId, BigDecimal money) {
                log.error("用户扣款失败，触发服务降级接口");
                return false;
            }
        };
    }
}
