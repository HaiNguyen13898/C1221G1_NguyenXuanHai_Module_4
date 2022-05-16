package com.exercise.service;

import com.exercise.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(Integer id);

    void borrowBook(Book book);

    void returnBook(Book book);


}
