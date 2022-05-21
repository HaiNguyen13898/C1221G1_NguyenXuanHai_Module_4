package com.exersice.repository;

import com.exersice.model.Smartphone;
import org.springframework.data.repository.CrudRepository;

public interface ISmartphoneRepository extends CrudRepository<Smartphone, Long> {
}
