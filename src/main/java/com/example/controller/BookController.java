package com.example.controller;

import com.example.entity.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/showAllBooks")
    public String showAllBooks(Model model){
        List<Book> list = bookService.findAll();
        model.addAttribute("books", list);
        return "books";
    }

    @GetMapping("/findBookByID")
    public String findByID(Model model, @RequestParam ("id") int id) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/deleteBookByID")
    public String deleteByID (@RequestParam ("id") int id) {
        bookService.deleteByID(id);
        return "redirect:/showAllBooks";
    }

    @GetMapping("/createBook")
    public String createBook (Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("url", "afterCreateBook");
        return "book-form";
    }

    @PostMapping("/afterCreateBook")
    public String afterCreateBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:/findBookByID?id=" + book.getId();
    }

    @GetMapping("/updateBook")
    public String updateBook (Model model, @RequestParam ("id") int id) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        model.addAttribute("url", "afterUpdateBook");
        return "book-form";
    }

    @PostMapping ("/afterUpdateBook")
    public String afterUpdateBook(@ModelAttribute("book") Book book) {
        bookService.update(book);
        return "redirect:/findBookByID?id=" + book.getId();
    }
}

