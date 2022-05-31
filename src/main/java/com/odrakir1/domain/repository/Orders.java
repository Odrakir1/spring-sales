package com.odrakir1.domain.repository;

import com.odrakir1.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Orders extends JpaRepository<Order, Integer> {
}
