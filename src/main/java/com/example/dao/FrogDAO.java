package com.example.dao;

import com.example.entity.Frog;

import java.util.List;

public interface FrogDAO {
    Frog getFrog(int id);

    List<Frog> getFrogs();

    void updateFrog(Frog frog);

    void createFrog(Frog frog);

    void deleteFrog(Frog frog);
}