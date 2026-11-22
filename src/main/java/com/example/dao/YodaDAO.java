package com.example.dao;

import com.example.entity.Yoda;

import java.util.List;

public interface YodaDAO {

    List<Yoda> getAllYodas ();
    Yoda getYoda (int id);
    void createYoda (Yoda yoda);
    void updateYoda (Yoda yoda);
    void deleteYoda (Yoda yoda);
}
