package com.example.dao;

import com.example.entity.Cat;

import java.util.List;

public interface CatDAO {
    Cat getCat (int id);
    List<Cat> getCats ();
    void deleteCat (Cat cat);
    void saveCat (Cat cat);
    void updateCat (Cat cat);
}
