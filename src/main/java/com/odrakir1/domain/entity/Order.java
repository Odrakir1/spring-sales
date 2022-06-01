package com.odrakir1.domain.entity;

import com.odrakir1.domain.repository.OrderItems;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "total", precision = 20, scale = 2)
    private BigDecimal total;

    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItems;

    public Set<OrderItem> getOrdersItems() {
        return orderItems;
    }

    public void setOrdersItems(Set<OrderItem> ordersItems) {
        this.orderItems = ordersItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getOrdersDate() {
        return orderDate;
    }

    public void setOrdersDate(LocalDate ordersDate) {
        this.orderDate = ordersDate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ordersDate=" + orderDate +
                ", total=" + total +
                '}';
    }
}
