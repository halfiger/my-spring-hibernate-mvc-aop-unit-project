package com.example.dao;

import com.example.entity.Mouse;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MouseDAOImpl implements MouseDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public MouseDAOImpl (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Mouse findMouse (int id) {
        return sessionFactory.getCurrentSession().get(Mouse.class, id);
    }

    @Override
    public List<Mouse> getMice () {
        return sessionFactory.getCurrentSession().createQuery("from Mouse", Mouse.class).getResultList();
    }

    @Override
    public void deleteMouse (Mouse mouse) {
        sessionFactory.getCurrentSession().remove(mouse);
    }

    @Override
    public void createMouse (Mouse mouse) {
        sessionFactory.getCurrentSession().persist(mouse);
    }

    @Override
    public void updateMouse (Mouse mouse) {
        sessionFactory.getCurrentSession().merge(mouse);
    }



}
