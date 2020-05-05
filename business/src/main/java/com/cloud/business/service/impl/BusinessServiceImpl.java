package com.cloud.business.service.impl;

import com.cloud.business.feign.OrderFeignClient;
import com.cloud.business.feign.StorageFeignClient;
import com.cloud.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lingjun.jlj
 * @date: 2019/7/3 14:54
 * @version：1.0
 * @description:
 */
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
    public void purchase(String userId, String commodityCode, int orderCount) {
        storageFeignClient.deduct(commodityCode, orderCount);

        orderFeignClient.create(userId, commodityCode, orderCount);
    }
}
