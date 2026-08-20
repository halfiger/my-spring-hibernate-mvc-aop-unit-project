package com.example.dao;

import com.example.entity.Car;

import java.util.List;

public interface CarDAO {
    List<Car> findAll();
    Car findById(int id);
    void save(Car car);
    void update(Car car);
    void deleteById(int id);
}
