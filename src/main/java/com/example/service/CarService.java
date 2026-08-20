package com.example.service;

import com.example.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> findAll();
    Car findById (int id);
    void save (Car car);
    void update (Car car);
    void deleteById (int id);

}
