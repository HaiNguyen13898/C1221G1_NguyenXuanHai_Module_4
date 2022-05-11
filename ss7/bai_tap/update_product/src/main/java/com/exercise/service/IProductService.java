package com.exercise.service;

import com.exercise.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
//    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(Product product);

    Page<Product> findAllsearchByName(String name, Pageable pageable);

}
