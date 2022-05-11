package com.exercise.repository;

import com.exercise.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IProductRepository extends JpaRepository<Product, Integer> {

}
