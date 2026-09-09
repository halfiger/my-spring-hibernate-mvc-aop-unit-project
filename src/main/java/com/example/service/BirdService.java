package com.example.service;

import com.example.entity.Bird;

import java.util.List;

public interface BirdService {
    Bird getBird (int id);
    List<Bird> getBirds ();
    void updateBird (Bird bird);
    void deleteBird (Bird bird);
    void saveBird (Bird bird);
}
