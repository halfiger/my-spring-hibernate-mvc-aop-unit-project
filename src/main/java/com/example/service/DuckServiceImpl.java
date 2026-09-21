package com.example.service;

import com.example.dao.DuckDAO;
import com.example.entity.Duck;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DuckServiceImpl implements DuckService {

    private final DuckDAO duckDAO;

    @Autowired
    public DuckServiceImpl (DuckDAO duckDAO) {
        this.duckDAO = duckDAO;
    }

    public List<Duck> getAllDucks () {
        return duckDAO.getAllDucks();
    }

    public Duck getDuck (int id) {
        return duckDAO.getDuck(id);
    }

    public void removeDuck (Duck duck) {
        duckDAO.removeDuck(duck);
    }

    public void updateDuck (Duck duck) {
        duckDAO.updateDuck(duck);
    }

    public void createDuck (Duck duck) {
        duckDAO.createDuck(duck);
    }
}
