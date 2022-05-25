package com.exercise.service.services.impl;

import com.exercise.model.serivces.Service;
import com.exercise.repository.service.IServiceRepository;
import com.exercise.service.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements IService {

    @Autowired
    IServiceRepository serviceRepository;


    @Override
    public List<Service> findAll2() {
        return serviceRepository.findAll();
    }



    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
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
