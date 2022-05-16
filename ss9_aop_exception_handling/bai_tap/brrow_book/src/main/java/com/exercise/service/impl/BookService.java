package com.exercise.service.impl;

import com.exercise.model.Book;
import com.exercise.repository.IBookRepository;
import com.exercise.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository iBookRepository;

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return iBookRepository.findById(id).orElse(null);
    }

    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public void borrowBook(Book book) {
        book.setAmount(book.getAmount() - 1);
        this.save(book);
    }

    @Override
    public void returnBook(Book book) {
        book.setAmount(book.getAmount() + 1);
        this.save(book);
    }


}