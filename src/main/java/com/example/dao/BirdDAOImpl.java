package com.example.dao;

import com.example.entity.Bird;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BirdDAOImpl implements BirdDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public BirdDAOImpl (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Bird getBird (int id) {
        return sessionFactory.getCurrentSession().get(Bird.class, id);
    }

    public List<Bird> getBirds () {
        return sessionFactory.getCurrentSession()
                .createQuery("from Bird", Bird.class)
                .getResultList();
    }

    public void updateBird (Bird bird) {
        sessionFactory.getCurrentSession().merge(bird);
    }

    public void saveBird (Bird bird) {
        sessionFactory.getCurrentSession().persist(bird);
    }

    public void deleteBird (Bird bird) {
        sessionFactory.getCurrentSession().remove(bird);
    }


}
