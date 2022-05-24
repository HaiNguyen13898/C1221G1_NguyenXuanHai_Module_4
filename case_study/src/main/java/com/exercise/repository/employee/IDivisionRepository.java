package com.exercise.repository.employee;

import com.exercise.model.empolyee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<Division, Integer> {
}
