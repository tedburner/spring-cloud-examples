package com.cloud.account.entity;

import com.cloud.common.constant.DatabaseConstants;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
@Table(name = DatabaseConstants.DB_TABLE_ACCOUNT_NAME)
@EntityListeners(AuditingEntityListener.class)
public class Account {

    @Id
    private Long id;
    private String userId;
    private BigDecimal money;
}
