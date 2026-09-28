package com.example.dao;

import com.example.entity.Bob;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BobDAOImpl implements BobDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public BobDAOImpl (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Bob getBob (int id) {
        return sessionFactory.getCurrentSession().get(Bob.class, id);
    }

    public List<Bob> getBobs () {
        return sessionFactory.getCurrentSession().createQuery("from Bob", Bob.class).getResultList();
    }

    public void createBob (Bob bob) {
        sessionFactory.getCurrentSession().persist(bob);
    }

    public void updateBob (Bob bob) {
        sessionFactory.getCurrentSession().merge(bob);
    }

    public void deleteBob (Bob bob) {
        sessionFactory.getCurrentSession().remove(bob);
    }
}
