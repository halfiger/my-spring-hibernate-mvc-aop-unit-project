package com.example.dao;


import com.example.entity.Fish;

import java.util.List;

public interface FishDAO {
    List<Fish> getFishes ();
    Fish getFish (int id);
    void createFish (Fish fish);
    void deleteFish (Fish fish);
    void updateFish (Fish fish);
}
