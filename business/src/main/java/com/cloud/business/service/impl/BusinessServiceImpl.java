package com.cloud.business.service.impl;

import com.cloud.business.feign.OrderFeignClient;
import com.cloud.business.feign.StorageFeignClient;
import com.cloud.business.service.BusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lingjun.jlj
 * @date: 2019/7/3 14:54
 * @version：1.0
 * @description:
 */
@Slf4j
@Service
public class BusinessServiceImpl implements BusinessService {

    private final StorageFeignClient storageFeignClient;
    private final OrderFeignClient orderFeignClient;

    @Autowired
    public BusinessServiceImpl(StorageFeignClient storageFeignClient, OrderFeignClient orderFeignClient) {
        this.storageFeignClient = storageFeignClient;
        this.orderFeignClient = orderFeignClient;
    }

    @Override
    public void purchase(String userId, String commodityCode, int commodityCount) {
        log.info("用户[{}]购买商品[{}]，数量：{}", userId, commodityCode, commodityCount);
        // 仓储扣款
        storageFeignClient.deduct(commodityCode, commodityCount);
        // 创建订单
        orderFeignClient.create(userId, commodityCode, commodityCount);
    }
}
