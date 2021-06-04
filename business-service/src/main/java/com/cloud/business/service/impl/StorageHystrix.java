package com.cloud.business.service.impl;

import com.cloud.business.feign.StorageFeignClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: lingjun.jlj
 * @date: 2021/4/21 21:16
 * @description:
 */
@Slf4j
@Component
public class StorageHystrix implements FallbackFactory<StorageFeignClient> {


    @Override
    public StorageFeignClient create(Throwable throwable) {
        return new StorageFeignClient() {
            @Override
            public void deduct(String commodityCode, Integer count) {
                log.info("扣除商品数据失败，仓储服务降级");
            }
        };
    }
}
