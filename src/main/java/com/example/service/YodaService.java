package com.example.service;

import com.example.entity.Yoda;

import java.util.List;

public interface YodaService {
    List<Yoda> getAllYodas ();
    Yoda getYoda();
    void createYoda();
    void deleteYoda();
    void updateYoda();
}