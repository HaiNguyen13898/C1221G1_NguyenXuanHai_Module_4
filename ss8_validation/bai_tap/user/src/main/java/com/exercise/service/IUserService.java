package com.exercise.service;

import com.exercise.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    //    List<User> findAll();
    void save(User user);

    void remove(User user);

    User findById(int id);

    Page<User> findAll(Pageable pageable);
}
