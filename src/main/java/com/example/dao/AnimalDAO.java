package com.example.dao;

import com.example.entity.Animal;

import java.util.List;

public interface AnimalDAO {
    List<Animal> findAll ();
    Animal findById (int id);
    void save (Animal animal);
    void update (Animal animal);
    void delete (Animal animal);
}
