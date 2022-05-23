package com.exercise.service.services;

import com.exercise.model.serivces.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService {

    Page<Service> findAllAndSearch (String name, String des, String area, Pageable pageable);

    void save(Service service);

    Service findById(int id);

    void update(Service service);

    void remove(Service service);
}
