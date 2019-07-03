package com.cloud.account.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author: lingjun.jlj
 * @date: 2019/7/3 10:14
 * @version：1.0
 * @description:
 */
@Data
@Entity
@Table(name = "account_tbl")
@DynamicUpdate
@DynamicInsert
public class Account {

    @Id
    private Long id;
    private String userId;
    private BigDecimal money;
}
