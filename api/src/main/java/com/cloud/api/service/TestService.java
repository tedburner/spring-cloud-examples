package com.cloud.api.service;

import com.cloud.api.damain.DO.UserDO;

import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/15 10:35
 * @description:
 */
public interface TestService {

    List<UserDO> findUserList();
}
