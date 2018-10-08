package com.cloud.common.service;

import com.cloud.common.damain.DO.UserDO;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/8 16:22
 * @description:
 */
public interface UserService {

    /**
     * 根据用户ID查询用户信息
     *
     * @param id
     */
    UserDO findUserById(Long id);
}
