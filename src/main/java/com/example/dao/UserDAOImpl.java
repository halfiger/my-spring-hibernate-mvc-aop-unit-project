package com.example.dao;

import com.example.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    @Override
    public User findByID(int id) {
        return sessionFactory.getCurrentSession()
                .get(User.class, id);
    }

    @Override
    public List<User> findAll() {

        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    public void update (User user) {
        sessionFactory.getCurrentSession().merge(user);
    }

    @Override
    public void deleteById(int id) {
        sessionFactory.getCurrentSession().remove(findByID(id));
    }
}