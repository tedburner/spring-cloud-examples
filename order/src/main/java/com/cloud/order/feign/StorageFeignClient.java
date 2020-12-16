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
@FeignClient(name = "storage-service")
public interface StorageFeignClient {

    /**
     * 远程调用扣除商品库存
     *
     * @param commodityCode 商品编号
     * @param count         购买数量
     * @return
     */
    @GetMapping("/deduct")
    Boolean debit(@RequestParam("commodityCode") String commodityCode, @RequestParam("money") Integer count);

    /**
     * 查询商品库存数量
     *
     * @param commodityCode 商品编号
     * @return
     */
    @GetMapping("/findById")
    Integer findById(@RequestParam("commodityCode") String commodityCode);
}
