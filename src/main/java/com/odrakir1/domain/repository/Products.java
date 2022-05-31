package com.odrakir1.domain.repository;

import com.odrakir1.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Products extends JpaRepository<Product, Integer> {
}
