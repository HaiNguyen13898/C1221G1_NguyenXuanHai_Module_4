package com.exercise.service.impl;

import com.exercise.model.User;
import com.exercise.repository.IUserRepository;
import com.exercise.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;

    //    @Override
//    public List<User> findAll() {
//        return this.userRepository.findAll();
//    }
    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void remove(User user) {
        this.userRepository.delete(user);
    }

    @Override
    public User findById(int id) {
        return this.userRepository.findById(id).orElse(null);
    }


}
