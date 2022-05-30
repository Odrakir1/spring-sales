package com.odrakir1;

import com.odrakir1.domain.entity.Customer;
import com.odrakir1.domain.repository.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SalesApplication {

    @Bean
    public CommandLineRunner init(@Autowired Customers customers){
      return args -> {
          Customer newCustomer = new Customer();
          newCustomer.setName("Linus");
          customers.save(newCustomer);

          Customer anotherCustomer = new Customer();
          anotherCustomer.setName("John");
          customers.save(anotherCustomer);

          List<Customer> customerList = customers.findAll();

          customerList.forEach(System.out::println);

          customerList.forEach(customer -> {
              customer.setName(customer.getName() + " updated");
              customers.save(customer);
          });

          customerList = customers.findAll();

          customerList.forEach(System.out::println);

          System.out.println(customers.findByNameContains("Linus"));

          customerList = customers.findAll();

          customerList.forEach(customer -> {customers.delete(customer);});

          customerList = customers.findAll();

          if(customerList.isEmpty())
              System.out.println("No customer found");
          else
            customerList.forEach(System.out::println);
      };

    }

    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }

}
