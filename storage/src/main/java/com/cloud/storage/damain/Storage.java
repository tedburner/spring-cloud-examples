package com.cloud.storage.damain;

import com.cloud.common.constant.DatabaseConstants;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/15 10:28
 * @description:
 */
@Data
@Entity
@Table(name = DatabaseConstants.DB_TABLE_STORAGE_NAME)
@EntityListeners(AuditingEntityListener.class)
public class Storage {

    @Id
    private Long id;
    private String commodityCode;
    private Integer count;
}
