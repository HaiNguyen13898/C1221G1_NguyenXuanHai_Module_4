package com.exersice.service;

import com.exersice.model.Smartphone;

import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();
    // Lis<Smartphone> findAll();

    Optional<Smartphone> findById(Long id);
    //Smartphone findById(Long id)

    Smartphone save(Smartphone smartPhone);

    void remove(Long id);
}
