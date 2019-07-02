package com.cloud.common.service.impl;

import com.cloud.common.damain.DO.UserDO;
import com.cloud.common.persist.UserMapper;
import com.cloud.common.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/8 16:22
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDO findUserById(Long id) {
        return userMapper.selectById(id);
    }
}
