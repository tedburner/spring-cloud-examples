package com.cloud.storage.service.impl;

import com.cloud.storage.damain.Storage;
import com.cloud.storage.repository.StorageRepository;
import com.cloud.storage.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/15 10:35
 * @description:
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageRepository storageRepository;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deduct(String commodityCode, int count) {
        Storage storage = storageRepository.findByCommodityCode(commodityCode);
        if (storage.getCount() < count) {
            log.error("商品[{}]数量为【{}】，不足【{}】", commodityCode, storage.getCount(), count);
            throw new RuntimeException("库存不足，更新库存失败");
        }
        storage.setCount(storage.getCount() - count);
        storageRepository.save(storage);
    }

    @Override
    public void deduct(String commodityCode, int count, String txKey) {
        Storage storage = storageRepository.findByCommodityCode(commodityCode);
        if (storage.getCount() < count) {
            log.info("库存不足，扣减失败。商品ID = {},商品当前库存 = {},所需库存 = {}，分布式事务key = {}", commodityCode, storage.getCount(), count, txKey);
            throw new RuntimeException("库存不足，更新库存失败");
        }
        storage.setCount(storage.getCount() - count);
        storageRepository.save(storage);
        log.info("更新库存成功。商品ID = {},商品当前库存 = {},所需库存 = {}，分布式事务key = {}", commodityCode, storage.getCount(), count, txKey);
    }

    @Override
    public Integer findById(String commodityCode) {
        Storage storage = storageRepository.findByCommodityCode(commodityCode);
        return storage.getCount();
    }
}
