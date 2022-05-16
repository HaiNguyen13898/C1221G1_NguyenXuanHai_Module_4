package com.exercise.repository;

import com.exercise.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowRepository extends JpaRepository<Borrow, Integer> {
    Borrow findByCode(Integer code);
}
