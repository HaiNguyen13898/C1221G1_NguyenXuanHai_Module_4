package com.exercise.repository;

import com.exercise.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findAllByProductNameContaining(String name, Pageable pageable);
}
