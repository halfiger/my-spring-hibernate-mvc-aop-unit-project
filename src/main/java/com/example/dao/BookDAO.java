package com.example.dao;

import com.example.entity.Book;

import java.util.List;

public interface BookDAO {
    List<Book> findAll();
    Book findById(int id);
    void save(Book book);
    void update(Book book);
    void deleteByID(int id);
}
