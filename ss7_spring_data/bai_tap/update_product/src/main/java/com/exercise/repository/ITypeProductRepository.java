package com.exercise.repository;

import com.exercise.model.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ITypeProductRepository extends JpaRepository<TypeProduct, Integer> {
}
