package com.exercise.service.impl;

import com.exercise.model.Borrow;
import com.exercise.repository.IBorrowRepository;
import com.exercise.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowService implements IBorrowService {

    @Autowired
    IBorrowRepository iBorrowRepository;

    @Override
    public void save(Borrow borrow) {
        iBorrowRepository.save(borrow);
    }

    @Override
    public Borrow findByCode(Integer code) {
        return iBorrowRepository.findByCode(code);
    }

    @Override
    public void deleteById(Integer id) {
        iBorrowRepository.deleteById(id);
    }
}
