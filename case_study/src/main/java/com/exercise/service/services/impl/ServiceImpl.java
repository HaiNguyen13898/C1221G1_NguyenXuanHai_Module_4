package com.exercise.service.services.impl;

import com.exercise.model.serivces.Service;
import com.exercise.repository.service.IServiceRepository;
import com.exercise.service.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@org.springframework.stereotype.Service
public class ServiceImpl implements IService {

    @Autowired
    IServiceRepository serviceRepository;

    @Override
    public Page<Service> findAllAndSearch(String name, String des, String area, Pageable pageable) {
        return this.serviceRepository.findAllBySvNameContainingAndAndDescriptionOtherConvenienceContainingAndAndPoolAreaContaining(name, des, area, pageable);
    }

    @Override
    public void save(Service service) {
        this.serviceRepository.save(service);
    }

    @Override
    public Service findById(int id) {
        return this.serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Service service) {
        this.serviceRepository.save(service);

    }

    @Override
    public void remove(Service service) {
        this.serviceRepository.delete(service);
    }


}
