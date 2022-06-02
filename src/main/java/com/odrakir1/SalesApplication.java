package com.odrakir1;

import com.odrakir1.domain.entity.Customer;
import com.odrakir1.domain.entity.Order;
import com.odrakir1.domain.repository.Customers;
import com.odrakir1.domain.repository.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SalesApplication {

    @Bean
    public CommandLineRunner init(@Autowired Customers customers, @Autowired Orders orders){
      return args -> {
          Customer newCustomer = new Customer();
          newCustomer.setName("Linus");
          customers.save(newCustomer);

          Order order = new Order();
          order.setCustomer(newCustomer);
          order.setOrdersDate(LocalDate.now());
          order.setTotal(BigDecimal.valueOf(1234.99));

          orders.save(order);

          Customer customer = customers.findCustomerFetchOrders(newCustomer.getId());
          System.out.println(customer);
          System.out.println(customer.getOrders());

          orders.findByCustomer(newCustomer).forEach(System.out::println);
      };

    }

    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }

}
