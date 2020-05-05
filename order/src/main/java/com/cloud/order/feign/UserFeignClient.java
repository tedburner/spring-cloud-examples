package com.cloud.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author: lingjun.jlj
 * @date: 2019/7/3 10:11
 * @version：1.0
 * @description:
 */
@FeignClient(name = "account-service")
public interface UserFeignClient {

    /**
     * 远程调用扣除用户金额
     *
     * @param userId 用户ID
     * @param money  金额
     * @return
     */
    @GetMapping("/debit")
    Boolean debit(@RequestParam("userId") String userId, @RequestParam("money") BigDecimal money);
}
