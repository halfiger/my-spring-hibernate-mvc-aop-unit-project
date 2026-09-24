package com.example.dao;

import com.example.entity.Tom;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TomDAOImpl implements TomDAO {
    private final SessionFactory sessionFactory;
    @Autowired
    public TomDAOImpl (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Tom getTom (int id) {
        return sessionFactory.getCurrentSession().get(Tom.class, id);
    }

    @Override
    public List<Tom> getToms () {
        return sessionFactory.getCurrentSession().createQuery("from Tom", Tom.class).getResultList();
    }

    @Override
    public void createTom (Tom tom) {
        sessionFactory.getCurrentSession().persist(tom);
    }

    @Override
    public void updateTom (Tom tom) {
        sessionFactory.getCurrentSession().merge(tom);
    }

    @Override
    public void deleteTom (Tom tom) {
        sessionFactory.getCurrentSession().remove(tom);
    }


}
