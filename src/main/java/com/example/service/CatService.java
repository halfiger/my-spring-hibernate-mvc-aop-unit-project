package com.example.service;

import com.example.entity.Cat;
import java.util.List;

public interface CatService {
    Cat getCat (int id);
    List<Cat> getCats ();
    void deleteCat (Cat cat);
    void saveCat (Cat cat);
    void updateCat (Cat cat);
}
