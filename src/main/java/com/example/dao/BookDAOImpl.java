package com.example.dao;

import com.example.entity.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public BookDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List <Book> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Book", Book.class)
                .getResultList();
    }

    @Override
    public Book findById(int id) {
        return sessionFactory.getCurrentSession().get(Book.class, id);
    }

    @Override
    public void deleteByID(int id) {
        sessionFactory.getCurrentSession().remove(findById(id));
    }

    @Override
    public void update(Book book) {
        sessionFactory.getCurrentSession().merge(book);
    }

    @Override
    public void save(Book book) {
        sessionFactory.getCurrentSession().persist(book);
    }
}
