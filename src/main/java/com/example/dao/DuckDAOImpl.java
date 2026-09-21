package com.example.dao;

import com.example.entity.Duck;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DuckDAOImpl implements DuckDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public DuckDAOImpl (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Duck> getAllDucks () {
        return sessionFactory.getCurrentSession().createQuery("from Duck", Duck.class).getResultList();
    }

    public Duck getDuck (int id) {
        return sessionFactory.getCurrentSession().get(Duck.class, id);
    }

    public void removeDuck (Duck duck) {
        sessionFactory.getCurrentSession().remove(duck);
    }

    public void updateDuck (Duck duck) {
        sessionFactory.getCurrentSession().merge(duck);
    }

    public void createDuck (Duck duck) {
        sessionFactory.getCurrentSession().persist(duck);
    }


}
