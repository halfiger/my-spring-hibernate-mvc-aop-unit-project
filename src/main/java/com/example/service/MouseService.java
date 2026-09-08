package com.example.service;

import com.example.entity.Mouse;

import java.util.List;

public interface MouseService {
    Mouse findMouse (int id);
    List<Mouse> getMice ();
    void deleteMouse (Mouse mouse);
    void createMouse (Mouse mouse);
    void updateMouse (Mouse mouse);
}
