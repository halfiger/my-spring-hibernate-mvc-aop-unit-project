package com.example.service;

import com.example.entity.Dog;

import java.util.List;

public interface DogService {
    List<Dog> showAll ();
    Dog showDog (int id);
    void update (Dog dog);
    void delete (Dog dog);
    void save (Dog dog);
}
