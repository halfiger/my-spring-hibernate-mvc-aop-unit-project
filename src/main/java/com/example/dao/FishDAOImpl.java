package com.example.dao;

import com.example.entity.Fish;
import com.example.service.FishService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FishDAOImpl implements FishDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public FishDAOImpl (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Fish> getFishes () {
        return sessionFactory.getCurrentSession()
                .createQuery("from Fish", Fish.class)
                .getResultList();
    }

    @Override
    public Fish getFish (int id) {
        return sessionFactory.getCurrentSession()
                .get(Fish.class, id);
    }

    @Override
    public void createFish (Fish fish) {
        sessionFactory.getCurrentSession()
                .persist(fish);
    }

    @Override
    public void deleteFish (Fish fish) {
        sessionFactory.getCurrentSession()
                .remove(fish);
    }

    @Override
    public void updateFish (Fish fish) {
        sessionFactory.getCurrentSession()
                .merge(fish);
    }


}
