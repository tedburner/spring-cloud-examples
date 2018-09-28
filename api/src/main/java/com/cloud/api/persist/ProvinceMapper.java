package com.cloud.api.persist;


import com.cloud.api.damain.DO.ProvinceDO;

/**
 * @author lingjun.jlj
 * @date 2017/12/2
 */
public interface ProvinceMapper {

    Long addProvince(ProvinceDO province);

    ProvinceDO selectProvinceById(Long id);
}
