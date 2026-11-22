package com.example.service;

import com.example.entity.Yoda;

import java.util.List;

public interface YodaService {
    List<Yoda> getAllYodas ();
    Yoda getYoda(int id);
    void createYoda(Yoda yoda);
    void deleteYoda(Yoda yoda);
    void updateYoda(Yoda yoda);
}