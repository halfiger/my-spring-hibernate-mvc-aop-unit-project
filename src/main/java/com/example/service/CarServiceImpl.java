package com.example.service;

import com.example.dao.CarDAO;
import com.example.entity.Car;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final CarDAO carDAO;

    @Autowired

    public CarServiceImpl (CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public List<Car> findAll() {
        return carDAO.findAll();
    }

    @Override
    public Car findById (int id) {
        return carDAO.findById(id);
    }

    @Override
    public void save (Car car) {
        carDAO.save(car);
    }

    @Override
    public void update (Car car) {
        carDAO.update(car);
    }

    @Override
    public void deleteById (int id) {
        carDAO.deleteById(id);
    }


}
