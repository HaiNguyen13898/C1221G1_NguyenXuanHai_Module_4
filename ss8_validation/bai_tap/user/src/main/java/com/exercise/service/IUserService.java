package com.exercise.service;

import com.exercise.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void save(User user);
    void remove(User user);
    User findById(int id);

}
