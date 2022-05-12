package com.exercise.service.impl;

import com.exercise.model.Product;
import com.exercise.repository.IProductRepository;
import com.exercise.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;


//    @Override
//    public List<Product> findAll() {
//        return productRepository.findAll();
//    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Page<Product> findAllsearchByName(String name,String des, Pageable pageable) {
        return productRepository.findAllByProductNameContainingAndDescriptionsContaining(name,des, pageable );
    }

//    @Override
//    public List<Product> searchByName(String nameProduct) {
//        return productRepository.searchByName(nameProduct);
//    }
}
