package com.exercise.repository;

import com.exercise.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
//    Page<Blog> findAll(Pageable pageable);
//    @Query (value = "select * from blog Where name_blog like :name",
//            countQuery = "select * from blog Where name_blog like :name" ,nativeQuery = true)
//    Page<Blog> searchByName (@Param("name") String name, Pageable pageable);

    Page<Blog> findAllByNameBlogContaining(String name, Pageable pageable);
}
