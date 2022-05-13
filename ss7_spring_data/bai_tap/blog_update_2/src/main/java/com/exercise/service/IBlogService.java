package com.exercise.service;

import com.exercise.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
//    List<Blog> findAll();
    void save(Blog blog);
    Blog findById(int id);
    void update(Blog blog);
    void remove(Blog blog);
//    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAndSearchByName (String name, Pageable pageable);

}
