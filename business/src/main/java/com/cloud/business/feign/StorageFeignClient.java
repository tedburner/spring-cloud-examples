package com.cloud.business.feign;

import com.cloud.business.service.impl.StorageHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lingjun.jlj
 * @date 2019/06/14
 */
@FeignClient(name = "storage-service", fallbackFactory = StorageHystrix.class)
@RequestMapping(value = "/storage")
public interface StorageFeignClient {

    /**
     * 扣除仓储中货物的数量
     *
     * @param commodityCode 商品码
     * @param count         购买数量
     */
    @GetMapping(value = "/deduct")
    void deduct(@RequestParam("commodityCode") String commodityCode,
                @RequestParam("count") Integer count);

}
