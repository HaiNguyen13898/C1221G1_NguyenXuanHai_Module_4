package com.exercise.service.impl;

import com.exercise.model.TypeProduct;
import com.exercise.repository.ITypeProductRepository;
import com.exercise.service.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProductService implements ITypeProductService {

    @Autowired
    private ITypeProductRepository typeProductRepository;

    @Override
    public List<TypeProduct> findAll() {
        return this.typeProductRepository.findAll();
    }
}
