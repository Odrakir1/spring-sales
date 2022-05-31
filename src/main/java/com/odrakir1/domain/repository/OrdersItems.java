package com.odrakir1.domain.repository;

import com.odrakir1.domain.entity.OrdersItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersItems extends JpaRepository<OrdersItem, Integer> {
}
