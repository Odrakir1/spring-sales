package com.odrakir1.domain.repository;

import com.odrakir1.domain.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Customers {
    private static String INSERT = "INSERT INTO Customer (name) values (?) ";
    private static String FIND_ALL = "SELECT * FROM Customer ";
    private static String UPDATE = "UPDATE Customer SET name = ? WHERE id = ? ";
    private static String DELETE = "DELETE FROM Customer WHERE id = ? ";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Customer save(Customer customer){
        jdbcTemplate.update(INSERT, customer.getName());
        return customer;
    }

    public List<Customer> findAll() throws SQLException{
       return jdbcTemplate.query(FIND_ALL, getRowMapper());
    }

    private RowMapper<Customer> getRowMapper() {
        return new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Customer(resultSet.getString("name"), resultSet.getInt("id"));
            }
        };
    }

    public Customer update(Customer customer){
        try {
            jdbcTemplate.update(UPDATE, customer.getName(), customer.getId());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return customer;
    }

    public void delete(Customer customer){
        try {
            jdbcTemplate.update(DELETE, customer.getId());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> findByName(String name) throws SQLException{
        return jdbcTemplate.query(FIND_ALL.concat("WHERE name LIKE ?"), new Object[] {"%" + name + "%"}, getRowMapper());
    }
}
