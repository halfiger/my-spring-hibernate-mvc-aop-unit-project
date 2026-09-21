package com.example.dao;

import com.example.entity.Duck;

import java.util.List;

public interface DuckDAO {
    List<Duck> getAllDucks ();
    Duck getDuck (int id);
    void removeDuck (Duck duck);
    void updateDuck (Duck duck);
    void createDuck (Duck duck);
}
