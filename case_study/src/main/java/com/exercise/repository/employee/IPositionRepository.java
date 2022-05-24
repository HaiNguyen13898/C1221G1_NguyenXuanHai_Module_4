package com.exercise.repository.employee;

import com.exercise.model.empolyee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position, Integer> {
}
