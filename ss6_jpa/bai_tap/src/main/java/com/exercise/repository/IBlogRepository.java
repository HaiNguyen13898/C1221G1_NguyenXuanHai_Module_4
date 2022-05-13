package com.exercise.repository;

import com.exercise.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query (value = "select * from blog Where name_blog like :name", nativeQuery = true)
    List<Blog> searchByName (@Param("name") String name);
}
