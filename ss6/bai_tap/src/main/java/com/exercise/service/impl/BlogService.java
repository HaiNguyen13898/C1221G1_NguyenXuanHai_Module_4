package com.exercise.service.impl;

import com.exercise.model.Blog;
import com.exercise.repository.IBlogRepository;
import com.exercise.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return this.blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return this.blogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void remove(Blog blog) {
        this.blogRepository.delete(blog);
    }
}
