package com.exercise.service.services.impl;

import com.exercise.model.serivces.RentType;
import com.exercise.repository.service.IRentTypeRepository;
import com.exercise.service.services.IRentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentType {
    @Autowired
    IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return this.rentTypeRepository.findAll();
    }
}
