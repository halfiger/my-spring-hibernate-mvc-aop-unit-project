package com.example.service;

import com.example.entity.Fish;

import java.util.List;

public interface FishService {
    List<Fish> getFishes ();
    Fish getFish (int id);
    void createFish (Fish fish);
    void deleteFish (Fish fish);
    void updateFish (Fish fish);
}
