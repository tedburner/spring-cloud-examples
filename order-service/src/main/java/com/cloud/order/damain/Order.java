package com.cloud.order.damain;

import com.cloud.common.constant.DatabaseConstants;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/8 16:14
 * @description: 订单表
 */
@Data
@Entity
@Table(name = DatabaseConstants.DB_TABLE_ORDER_NAME)
@EntityListeners(AuditingEntityListener.class)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String commodityCode;
    private BigDecimal money;
    private Integer count;
}
