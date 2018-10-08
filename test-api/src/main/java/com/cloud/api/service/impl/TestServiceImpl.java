package com.cloud.api.service.impl;

import com.cloud.api.damain.DO.UserDO;
import com.cloud.api.persist.UserMapper;
import com.cloud.api.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/15 10:35
 * @description:
 */

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserDO> findUserList() {
        return userMapper.selectUser();
    }
}
