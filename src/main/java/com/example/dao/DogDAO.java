package com.example.dao;

import com.example.entity.Dog;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DogDAO {
    List<Dog> showAll ();
    Dog showDog (int id);
    void delete (Dog dog);
    void save (Dog dog);
    void update (Dog dog);
}
