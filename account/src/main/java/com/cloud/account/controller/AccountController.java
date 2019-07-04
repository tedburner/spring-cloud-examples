package com.cloud.account.controller;

import com.cloud.account.service.UserService;
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
@RestController
public class AccountController {

    @Autowired
    private UserService userService;

    @RequestMapping("/debit")
    public Boolean debit(String userId, BigDecimal money) {
        userService.debit(userId, money);

        return true;
    }
}
