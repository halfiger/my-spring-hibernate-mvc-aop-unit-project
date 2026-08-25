package com.example.dao;

import com.example.entity.Animal;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnimalDAOImpl implements AnimalDAO{

    private final SessionFactory sessionFactory;

    @Autowired
    public AnimalDAOImpl (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
     public List<Animal>  findAll () {
         return sessionFactory
                 .getCurrentSession()
                 .createQuery("from Animal", Animal.class)
                 .getResultList();
     }

     @Override
     public Animal findById (int id) {
        return sessionFactory.getCurrentSession()
                .get(Animal.class, id);
     }

     @Override
    public void save (Animal animal) {
        sessionFactory.getCurrentSession()
                .persist(animal);
     }

     @Override
    public void delete (int id) {
        sessionFactory.getCurrentSession()
                .remove(findById(id));
     }

    @Override
     public void update (Animal animal) {
        sessionFactory.getCurrentSession().merge(animal);
     }

}
