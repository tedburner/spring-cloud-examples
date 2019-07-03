package com.cloud.api.service.impl;

import com.cloud.api.damain.Storage;
import com.cloud.api.repository.StorageRepository;
import com.cloud.api.service.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/15 10:35
 * @description:
 */

@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageRepository storageRepository;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deduct(String commodityCode, int count) {
        Storage storage = storageRepository.findByCommodityCode(commodityCode);
        storage.setCount(storage.getCount() - count);

        storageRepository.save(storage);
    }
}
