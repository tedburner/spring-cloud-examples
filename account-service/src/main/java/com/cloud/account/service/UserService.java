package com.cloud.account.service;

import java.math.BigDecimal;

/**
 * @author: lingjun.jlj
 * @date: 2019/7/3 10:13
 * @version：1.0
 * @description:
 */
public interface UserService {


    /**
     * 用户扣款
     *
     * @param userId
     * @param num
     */
    void debit(String userId, BigDecimal num);
}
