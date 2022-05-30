package com.odrakir1.domain.repository;

import com.odrakir1.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface Customers extends JpaRepository<Customer, Integer> {

    List<Customer> findByNameContains(String name);
}
