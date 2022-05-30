package com.odrakir1.domain.repository;

import com.odrakir1.domain.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Customers {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    EntityManager entityManager;

    @Transactional
    public Customer save(Customer customer){
        entityManager.persist(customer);
        return customer;
    }

    @Transactional
    public List<Customer> findAll() throws SQLException{
       return entityManager.createQuery("FROM Customer", Customer.class).getResultList();
    }

    @Transactional
    public Customer update(Customer customer){
        entityManager.merge(customer);

        return customer;
    }

    @Transactional
    public void delete(Customer customer){
        if(!entityManager.contains(customer))
            customer = entityManager.merge(customer);

        entityManager.remove(customer);
    }

    @Transactional(readOnly = true)
    public List<Customer> findByName(String name) throws SQLException{
        String jpql = "SELECT c from Customer c WHERE c.name LIKE :name";
        TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
        query.setParameter("name", "%" + name + "%") ;

        return query.getResultList();
    }
}
