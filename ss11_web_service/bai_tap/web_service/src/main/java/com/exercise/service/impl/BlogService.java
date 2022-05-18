package com.exercise.service.impl;

import com.exercise.model.Blog;
import com.exercise.repository.IBlogRepository;
import com.exercise.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

//    @Override
//    public List<Blog> findAll() {
//        return this.blogRepository.findAll();
//    }

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

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return this.blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAndSearchByName(String name, Pageable pageable) {
        return this.blogRepository.findAllByNameBlogContaining(name, pageable);
    }

    @Override
    public List<Blog> findAllByCategory_NameCategory(String nameCategory) {
        return this.blogRepository.findAllByCategory_NameCategory(nameCategory);
    }

//    @Override
//    public Page<Blog> findAll(Pageable pageable) {
//        return blogRepository.findAll(pageable);
//    }


}
