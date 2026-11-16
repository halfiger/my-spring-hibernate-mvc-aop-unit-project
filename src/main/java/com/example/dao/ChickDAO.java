package com.example.dao;

import com.example.entity.Chick;

import java.util.List;

public interface ChickDAO {
    List<Chick> getChicks ();
    Chick getChick (int id);
    void removeChick (Chick chick);
    void createChick (Chick chick);
    void updateChick (Chick chick);
}

