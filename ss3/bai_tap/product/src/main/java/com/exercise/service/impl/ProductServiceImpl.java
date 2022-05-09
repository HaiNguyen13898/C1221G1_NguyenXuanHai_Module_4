package com.exercise.service.impl;

import com.exercise.model.Product;
import com.exercise.repository.IProductRepository;
import com.exercise.repository.impl.ProductRepositoryImpl;
import com.exercise.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements IProductService {
    private IProductRepository productRepository = new ProductRepositoryImpl();
//    static {
//        productMap = new HashMap<>();
//        productMap.put(1, new Product(1, "Dream", 1000.0, "Còn zin", "Thái"));
//        productMap.put(2, new Product(2, "Honda Lead", 2000.0, "Còn zin", "Lào"));
//        productMap.put(3, new Product(3, "Honda Vision", 3000.0, "Hết zin", "Campuchia"));
//        productMap.put(4, new Product(4, "Honda AirBlack ", 1500.0, "Hết zin", "Việt Nam"));
//        productMap.put(5, new Product(5, "Yamaha Exciter", 1200.0, "Còn zin", "Hàn Quốc"));
//
//    }


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public void remove(Product product) {
        productRepository.remove(product);
    }

//    @Override
//    public List<Product> searchByName(String nameProduct) {
//        List<Product> productList = new ArrayList<>();
//        for (Product product : productMap.values()) {
//            if (product.getProductName().toLowerCase().contains(nameProduct)) {
//                productList.add(product);
//            }
//        }
//        return productList;
//    }
}
