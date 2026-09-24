package com.example.service;

import com.example.entity.Tom;

import java.util.List;

public interface TomService {
    Tom getTom (int id);
    List<Tom> getToms ();
    void createTom (Tom tom);
    void deleteTom (Tom tom);
    void updateTom (Tom tom);
}
