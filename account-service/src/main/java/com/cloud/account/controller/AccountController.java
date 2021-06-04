package com.cloud.account.controller;

import com.cloud.account.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author: lingjun.jlj
 * @date: 2019/7/3 10:15
 * @version：1.0
 * @description:
 */
@Slf4j
@RestController
public class AccountController {

    private final UserService userService;

    @Autowired
    public AccountController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户账户扣除金额
     *
     * @param userId
     * @param money
     * @return
     */
    @RequestMapping("/debit")
    public Boolean debit(String userId, BigDecimal money) {
        log.info("用户[{}]扣除金额：{}", userId, money);
        userService.debit(userId, money);
        return true;
    }
}
