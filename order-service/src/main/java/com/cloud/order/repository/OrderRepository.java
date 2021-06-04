package com.cloud.order.repository;

import com.cloud.order.damain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/8 16:17
 * @description:
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
