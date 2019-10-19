package com.cloud.storage.damain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/15 10:28
 * @description:
 */
@Data
@Entity
@Table(name = "storage_tbl")
@DynamicUpdate
@DynamicInsert
public class Storage {

    @Id
    private Long id;
    private String commodityCode;
    private Integer count;
}
