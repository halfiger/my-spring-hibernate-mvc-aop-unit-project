package com.example.service;

import com.example.entity.Animal;

import java.util.List;

public interface AnimalService {

    List<Animal> findAll ();
    Animal findById (int id);
    void delete (int id);
    void update (Animal animal);
    void save (Animal animal);

}
