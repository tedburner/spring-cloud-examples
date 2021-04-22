package com.cloud.order.feign;

import com.cloud.order.service.impl.UserHystrix;
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
@FeignClient(name = "account-service", fallbackFactory = UserHystrix.class)
public interface UserFeignClient {

    /**
     * 远程调用扣除用户金额
     *
     * @param userId 用户ID
     * @param money  金额
     * @return
     */
    @GetMapping(path = "/debit")
    Boolean debit(@RequestParam("userId") String userId, @RequestParam("money") BigDecimal money);

}
