package com.example.dao;

import com.example.entity.Mouse;

import java.util.List;

public interface MouseDAO {
    Mouse findMouse (int id);
    List<Mouse> getMice ();
    void deleteMouse (Mouse mouse);
    void createMouse (Mouse mouse);
    void updateMouse (Mouse mouse);
}
