package com.example.dao;

import com.example.entity.Yoda;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class YodaDAOImpl implements YodaDAO {
    private final SessionFactory sessionFactory;

    public YodaDAOImpl (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public List<Yoda> getAllYodas () {
        return sessionFactory.getCurrentSession()
                .createQuery("from Yoda", Yoda.class)
                .getResultList();
    }

    public Yoda getYoda (int id) {
        return sessionFactory.getCurrentSession()
                .get(Yoda.class, id);
    }

    public void createYoda (Yoda yoda) {
        sessionFactory.getCurrentSession()
                .persist(yoda);
    }

    public void deleteYoda (Yoda yoda) {
        sessionFactory.getCurrentSession()
                .remove(yoda);
    }

    public void updateYoda (Yoda yoda) {
        sessionFactory.getCurrentSession()
                .merge(yoda);
    }


}
