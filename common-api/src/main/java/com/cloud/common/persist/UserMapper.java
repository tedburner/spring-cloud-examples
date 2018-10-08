package com.cloud.common.persist;

import com.cloud.common.damain.DO.UserDO;

import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/8 16:17
 * @description:
 */
public interface UserMapper {

    UserDO selectById(Long id);

    void addUser(UserDO user);

    void update(UserDO userDO);

    List<UserDO> selectUser();
}
