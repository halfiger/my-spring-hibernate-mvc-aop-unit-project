package com.example.dao;

import com.example.entity.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CarDAOImpl implements CarDAO {

    SessionFactory sessionFactory;

    @Autowired
    public CarDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Car> findAll () {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Car",  Car.class)
                .getResultList();
    }

    @Override
    public Car findById (int id) {
        return sessionFactory
                .getCurrentSession()
                .get(Car.class, id);
    }

    @Override
    public void save (Car car) {
        sessionFactory
                .getCurrentSession()
                .persist(car);
    }

    @Override
    public void update (Car car) {
        sessionFactory
                .getCurrentSession()
                .merge(car);
    }

    @Override
    public void deleteById (int id) {
        sessionFactory
                .getCurrentSession()
                .remove(findById(id));
    }
}
