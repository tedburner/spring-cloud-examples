package com.cloud.account.repository;

import com.cloud.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: lingjun.jlj
 * @date: 2019/7/3 10:17
 * @version：1.0
 * @description:
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUserId(String userId);
}
