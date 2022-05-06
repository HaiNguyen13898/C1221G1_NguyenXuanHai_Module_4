package com.exercise.service;

import com.exercise.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements IProductService {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Dream", 1000.0, "Còn zin", "Thái"));
        productMap.put(2, new Product(2, "Honda Lead", 2000.0, "Còn zin", "Lào"));
        productMap.put(3, new Product(3, "Honda Vision", 3000.0, "Hết zin", "Campuchia"));
        productMap.put(4, new Product(4, "Honda AirBlack ", 1500.0, "Hết zin", "Việt Nam"));
        productMap.put(5, new Product(5, "Yamaha Exciter", 1200.0, "Còn zin", "Hàn Quốc"));

    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        product.setId((int) (Math.random() * 100));
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> searchByName(String nameProduct) {
        List<Product> productList = new ArrayList<>();
        for (Product product : productMap.values()) {
            if (product.getProductName().contains(nameProduct)) {
                productList.add(product);
            }
        }
        return productList;
    }
}
