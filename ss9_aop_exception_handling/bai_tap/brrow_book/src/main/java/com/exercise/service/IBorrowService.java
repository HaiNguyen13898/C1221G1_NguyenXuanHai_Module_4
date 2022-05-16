package com.exercise.service;

import com.exercise.model.Borrow;

public interface IBorrowService {

    void save(Borrow borrow);

    Borrow findByCode(Integer code);

    void deleteById(Integer id);
}
