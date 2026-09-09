package com.example.dao;

import com.example.entity.Bird;

import java.util.List;

public interface BirdDAO {
    Bird getBird (int id);
    List<Bird> getBirds ();
    void updateBird (Bird bird);
    void deleteBird (Bird bird);
    void saveBird (Bird bird);
}
