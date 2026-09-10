package com.example.service;

import com.example.entity.Frog;

import java.util.List;

public interface FrogService {
    Frog getFrog(int id);

    List<Frog> getFrogs();

    void updateFrog(Frog frog);

    void createFrog(Frog frog);

    void deleteFrog(Frog frog);
}