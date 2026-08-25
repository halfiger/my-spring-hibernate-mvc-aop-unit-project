package com.example.service;

import com.example.dao.AnimalDAO;
import com.example.entity.Animal;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AnimalServiceImpl {

    private AnimalDAO animalDAO;

    @Autowired
    public AnimalServiceImpl (AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }

    public List<Animal> findAll () {
        return animalDAO.findAll();
    }

    public Animal findById(int id) {
        return animalDAO.findById(id);
    }

    public void save (Animal animal) {
        animalDAO.save(animal);
    }

    public void delete (Animal animal) {
        animalDAO.delete(animal);
    }

    public void update (Animal animal) {
        animalDAO.update(animal);
    }

}
