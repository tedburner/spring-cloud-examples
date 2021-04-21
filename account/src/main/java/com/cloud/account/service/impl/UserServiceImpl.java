package com.cloud.account.service.impl;

import com.cloud.account.entity.Account;
import com.cloud.account.repository.AccountRepository;
import com.cloud.account.service.UserService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private static final String ERROR_USER_ID = "1002";

    private final AccountRepository accountRepository;

    @Autowired
    public UserServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void debit(String userId, BigDecimal num) {
        Account account = accountRepository.findByUserId(userId);
        // a小于b=-1
        int compare = num.compareTo(account.getMoney());
        if (compare > -1) {
            log.error("扣款失败，用户[{}]金额不足【{}】", userId, num);
            throw new RuntimeException("余额不足，扣款失败");
        }
        BigDecimal money = account.getMoney().subtract(num);
        account.setMoney(money);
        accountRepository.save(account);

        if (ERROR_USER_ID.equals(userId)) {
            throw new RuntimeException("account branch exception");
        }
    }

}
