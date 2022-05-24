package com.exercise.service.employee.impl;

import com.exercise.model.empolyee.Division;
import com.exercise.repository.employee.IDivisionRepository;
import com.exercise.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    IDivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return this.divisionRepository.findAll();
    }
}
