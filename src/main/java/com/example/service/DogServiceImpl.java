package com.example.service;

import com.example.dao.DogDAO;
import com.example.entity.Dog;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DogServiceImpl implements DogService {

    private final DogDAO dogDAO;

    @Autowired
    public DogServiceImpl (DogDAO dogDAO) {
        this.dogDAO = dogDAO;
    }

    @Override
    public List<Dog> showAll () {
        return dogDAO.showAll();
    }

    @Override
    public Dog showDog (int id) {
        return dogDAO.showDog(id);
    }

    @Override
    public void save (Dog dog) {
        dogDAO.save(dog);
    }

    @Override
    public void update (Dog dog) {
        dogDAO.update(dog);
    }

    @Override
    public void delete (Dog dog) {
        dogDAO.delete(dog);
    }

 }
