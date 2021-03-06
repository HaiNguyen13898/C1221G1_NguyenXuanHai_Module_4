package com.exercise.service;

import com.exercise.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void update( Product product);
    void remove(Product product);
    List<Product> searchByName(String nameProduct);

}
