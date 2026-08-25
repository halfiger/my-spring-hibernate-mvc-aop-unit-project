package com.example.service;

import com.example.dao.AnimalDAO;
import com.example.entity.Animal;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AnimalServiceImpl implements AnimalService {

    private final AnimalDAO animalDAO;

    @Autowired
    public AnimalServiceImpl (AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }

    @Override
    public List<Animal> findAll () {
        return animalDAO.findAll();
    }

    @Override
    public Animal findById(int id) {
        return animalDAO.findById(id);
    }

    @Override
    public void save (Animal animal) {
        animalDAO.save(animal);
    }

    @Override
    public void delete (int id) {
        animalDAO.delete(id);
    }

    @Override
    public void update (Animal animal) {
        animalDAO.update(animal);
    }

}
