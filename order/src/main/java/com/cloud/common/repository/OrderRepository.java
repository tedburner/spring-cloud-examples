package com.cloud.common.repository;

import com.cloud.common.damain.DO.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/8 16:17
 * @description:
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
