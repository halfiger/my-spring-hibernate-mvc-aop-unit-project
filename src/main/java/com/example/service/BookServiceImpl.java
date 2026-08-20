package com.example.service;

import com.example.dao.BookDAO;
import com.example.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;

    @Autowired
    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookDAO.findById(id);
    }

    @Override
    public void save(Book book) {
        bookDAO.save(book);
    }

    @Override
    public void update(Book book) {
        bookDAO.update(book);
    }

    @Override
    public void deleteByID(int id) {
        bookDAO.deleteByID(id);
    }
}
