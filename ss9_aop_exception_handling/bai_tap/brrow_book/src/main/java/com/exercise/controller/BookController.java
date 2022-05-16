package com.exercise.controller;


import com.exercise.model.Book;
import com.exercise.model.Borrow;
import com.exercise.service.IBorrowService;
import com.exercise.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService bookService;

    @Autowired
    IBorrowService borrowService;

    @GetMapping("")
    public String listBook(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "list_book";
    }

    @GetMapping("/borrow/{id}")
    public String borrowBookForm(@PathVariable Integer id, Model model) {
        Book book = bookService.findById(id);
        Borrow borrow = new Borrow();
        Integer borrowCode = (int) (Math.random() * 100000);
        borrow.setCode(borrowCode);
        model.addAttribute("book", book);
        model.addAttribute("borrow", borrow);
        return "borrow_book";
    }

    @PostMapping("/borrow/{id}")
    public String borrowBook(@PathVariable Integer id, @ModelAttribute Borrow borrow, RedirectAttributes redirectAttributes) {
        Book book = bookService.findById(id);
        borrow.setBook(book);
        borrowService.save(borrow);
        bookService.borrowBook(book);
        redirectAttributes.addFlashAttribute("message", "borrow success");
        return "redirect:/book";
    }

    @GetMapping("/return")
    public String returnForm(){
        return "return_book";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam Integer code,RedirectAttributes redirectAttributes){
        Borrow borrow = borrowService.findByCode(code);
        if(borrow != null){
            Book book = bookService.findById(borrow.getBook().getId());
            bookService.returnBook(book);
            borrowService.deleteById(borrow.getId());
            redirectAttributes.addFlashAttribute("message","return success");
            return "redirect:/book";
        } else {
            return "not_found_code";
        }
    }



}
