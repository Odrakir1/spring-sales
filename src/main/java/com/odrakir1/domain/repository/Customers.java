package com.odrakir1.domain.repository;

import com.odrakir1.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Customers extends JpaRepository<Customer, Integer> {

    List<Customer> findByNameContains(String name);

        @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.order WHERE c.id = :id")
        Customer findCustomerFetchOrders(@Param("id") Integer id);
}
