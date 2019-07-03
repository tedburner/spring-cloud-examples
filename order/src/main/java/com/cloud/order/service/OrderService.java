package com.cloud.order.service;

import com.cloud.order.damain.DO.UserDO;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/8 16:22
 * @description:
 */
public interface OrderService {

    /**
     * 根据用户ID查询用户信息
     *
     * @param id
     */
    void findUserById(Long id);
}
