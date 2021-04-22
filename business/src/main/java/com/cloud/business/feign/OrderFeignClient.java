package com.cloud.business.feign;

import com.cloud.business.service.impl.OrderHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Arthas
 * @date 2019/06/14
 */
@FeignClient(name = "order-service", fallbackFactory = OrderHystrix.class)
@RequestMapping(value = "/order")
public interface OrderFeignClient {

    /**
     * 创建订单
     *
     * @param userId        用户
     * @param commodityCode 商品code
     * @param count         购买数量
     */
    @GetMapping("/create")
    void create(@RequestParam("userId") String userId,
                @RequestParam("commodityCode") String commodityCode,
                @RequestParam("count") Integer count);

}
