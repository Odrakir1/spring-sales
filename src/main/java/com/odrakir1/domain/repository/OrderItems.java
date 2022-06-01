package com.odrakir1.domain.repository;

import com.odrakir1.domain.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItems extends JpaRepository<OrderItem, Integer> {
}
