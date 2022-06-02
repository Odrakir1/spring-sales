package com.odrakir1.domain.repository;

import com.odrakir1.domain.entity.Customer;
import com.odrakir1.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface Orders extends JpaRepository<Order, Integer> {
    Set<Order> findByCustomer(Customer customer);
}
