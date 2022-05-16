package com.exercise.repository;

import com.exercise.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository <Book, Integer> {

}
