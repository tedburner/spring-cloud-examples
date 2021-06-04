package com.cloud.storage.repository;

import com.cloud.storage.damain.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description：
 *
 * @author Arthas
 * @date 2019-04-04
 */
public interface StorageRepository extends JpaRepository<Storage, String> {

    Storage findByCommodityCode(String commodityCode);

}
