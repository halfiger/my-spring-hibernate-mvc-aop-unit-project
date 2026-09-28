package com.example.service;


import com.example.entity.Bob;

import java.util.List;

public interface BobService {
    Bob getBob (int id);
    List<Bob> getBobs();
    void createBob (Bob bob);
    void updateBob (Bob bob);
    void deleteBob (Bob bob);
}