package com.exercise.repository.service;

import com.exercise.model.serivces.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service, Integer> {
    //    Page<Service> findAllBySvNameContainingAndDescriptionOtherConvenienceContainingAndPoolAreaContaining
//            (String name, String des, String area, Pageable pageable);
    Page<Service> findAllBySvNameContainingAndSvAreaContainingAndSvCostContaining(
            String name, String area, String cost, Pageable pageable);

    Page<Service> findAll(Pageable pageable);


}
