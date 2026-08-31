package com.example.dao;

import com.example.entity.Dog;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DogDAOImpl implements DogDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public DogDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List showAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Dog", Dog.class)
                .getResultList();
    }

    @Override
    public Dog showDog(int id) {
        return sessionFactory.getCurrentSession().get(Dog.class, id);
    }

    @Override
    public void save(Dog dog) {
        sessionFactory.getCurrentSession().persist(dog);
    }

    public void update(Dog dog) {
        sessionFactory.getCurrentSession().merge(dog);
    }

    public void delete(Dog dog) {
        sessionFactory.getCurrentSession().remove(dog);
    }
}
