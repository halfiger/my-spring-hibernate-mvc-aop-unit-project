package com.example.dao;

import com.example.entity.Chick;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChickDAOImpl implements ChickDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public ChickDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Chick> getChicks() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Chick", Chick.class)
                .getResultList();
    }

    public Chick getChick(int id) {
        return sessionFactory.getCurrentSession()
                .get(Chick.class, id);
    }

    public void removeChick(Chick chick) {
        sessionFactory.getCurrentSession().remove(chick);
    }

    public void updateChick(Chick chick) {
        sessionFactory.getCurrentSession().merge(chick);
    }


    public void createChick(Chick chick) {
        sessionFactory.getCurrentSession().persist(chick);
    }

}
