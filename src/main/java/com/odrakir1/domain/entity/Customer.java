package com.odrakir1.domain.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Order> order;

    public Customer() {};

    public Customer(String name) {
        this.name = name;
    }

    public Set<Order> getOrders() {
        return order;
    }

    public void setOrders(Set<Order> order) {
        this.order = order;
    }

    public Customer(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
