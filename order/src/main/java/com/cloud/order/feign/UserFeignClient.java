package com.cloud.order.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: lingjun.jlj
 * @date: 2019/7/3 10:11
 * @version：1.0
 * @description:
 */
@FeignClient(name = "account-service")
public interface UserFeignClient {
}
