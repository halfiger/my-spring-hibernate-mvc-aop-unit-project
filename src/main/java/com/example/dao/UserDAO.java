package com.example.dao;

import com.example.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();
    User findByID(int id);
    void save (User user);
    void update (User user);
    void deleteById(int id);
}
