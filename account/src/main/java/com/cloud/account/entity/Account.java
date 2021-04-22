package com.cloud.account.entity;

import com.cloud.common.constant.DatabaseConstants;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author: lingjun.jlj
 * @date: 2019/7/3 10:14
 * @version：1.0
 * @description: 用户表
 */
@Data
@Entity
@Table(name = DatabaseConstants.DB_TABLE_ACCOUNT_NAME)
@EntityListeners(AuditingEntityListener.class)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private BigDecimal money;
}
