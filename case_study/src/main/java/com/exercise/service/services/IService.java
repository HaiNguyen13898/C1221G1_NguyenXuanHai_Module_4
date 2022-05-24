package com.exercise.service.services;

import com.exercise.model.serivces.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IService {

    Page<Service> findAllAndSearch(String name, String area, String cost, Pageable pageable); // fail

    Page<Service> findAll(Pageable pageable);

    void save(Service service);

    Service findById(int id);

    void update(Service service);

    void remove(Service service);
}
