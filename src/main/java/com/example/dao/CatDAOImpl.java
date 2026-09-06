package com.example.dao;

import com.example.entity.Cat;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CatDAOImpl implements CatDAO{
    private final SessionFactory sessionFactory;

    @Autowired
    public CatDAOImpl (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Cat getCat (int id) {
        return sessionFactory.getCurrentSession().get(Cat.class, id);
    }
    @Override
    public List<Cat> getCats() {
        return sessionFactory.getCurrentSession().createQuery("from Cat", Cat.class).getResultList();
    }

    @Override
    public void deleteCat (Cat cat) {
        sessionFactory.getCurrentSession().remove(cat);
    }

    @Override
    public void saveCat (Cat cat) {
        sessionFactory.getCurrentSession().persist(cat);
    }

    @Override
    public void updateCat (Cat cat) {
        sessionFactory.getCurrentSession().merge(cat);
    }




}
