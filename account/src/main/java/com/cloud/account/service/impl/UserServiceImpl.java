package com.cloud.account.service.impl;

import com.cloud.account.entity.Account;
import com.cloud.account.repository.AccountRepository;
import com.cloud.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author: lingjun.jlj
 * @date: 2019/7/3 10:13
 * @version：1.0
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    private static final String ERROR_USER_ID = "1002";
    @Autowired
    private AccountRepository accountRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void debit(String userId, BigDecimal num) {
        Account account = accountRepository.findByUserId(userId);
        account.setMoney(account.getMoney().subtract(num));
        accountRepository.save(account);

        if (ERROR_USER_ID.equals(userId)) {
            throw new RuntimeException("account branch exception");
        }
    }

}
