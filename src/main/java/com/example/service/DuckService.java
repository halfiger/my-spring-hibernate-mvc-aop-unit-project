package com.example.service;

import com.example.entity.Duck;

import java.util.List;

public interface DuckService {
    List<Duck> getAllDucks ();
    Duck getDuck (int id);
    void removeDuck (Duck duck);
    void updateDuck (Duck duck);
    void createDuck (Duck duck);

}
