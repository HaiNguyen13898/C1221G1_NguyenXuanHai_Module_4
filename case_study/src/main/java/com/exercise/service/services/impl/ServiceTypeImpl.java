package com.exercise.service.services.impl;

import com.exercise.model.serivces.ServiceType;
import com.exercise.repository.service.IServiceTypeRepository;
import com.exercise.service.services.IServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeImpl implements IServiceType {
    @Autowired
    IServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return this.serviceTypeRepository.findAll();
    }
}
