package com.example.dao;

import com.example.entity.Frog;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FrogDAOImpl implements FrogDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public FrogDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Frog getFrog(int id) {
        return sessionFactory.getCurrentSession().get(Frog.class, id);
    }

    public List<Frog> getFrogs() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Frog", Frog.class).getResultList();
    }

    public void deleteFrog(Frog frog) {
        sessionFactory.getCurrentSession().remove(frog);
    }

    public void createFrog(Frog frog) {
        sessionFactory.getCurrentSession().persist(frog);
    }

    public void updateFrog(Frog frog) {
        sessionFactory.getCurrentSession().merge(frog);
    }
}