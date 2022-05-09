package com.exercise.repository;

import com.exercise.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void update( Product product);
    void remove(Product product);
}
