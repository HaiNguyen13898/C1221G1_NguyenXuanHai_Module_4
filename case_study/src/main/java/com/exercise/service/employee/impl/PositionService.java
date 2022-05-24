package com.exercise.service.employee.impl;

import com.exercise.model.empolyee.Position;
import com.exercise.repository.employee.IPositionRepository;
import com.exercise.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    IPositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return this.positionRepository.findAll();
    }
}
