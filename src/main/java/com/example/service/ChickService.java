package com.example.service;

import com.example.dao.ChickDAOImpl;
import com.example.entity.Chick;

import java.util.List;

public interface ChickService {

        List<Chick> getChicks ();
        Chick getChick (int id);
        void removeChick (Chick chick);
        void updateChick (Chick chick);
        void createChick (Chick chick);
}
