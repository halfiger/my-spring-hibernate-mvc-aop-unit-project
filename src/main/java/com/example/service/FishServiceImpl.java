package com.example.service;

import com.example.dao.FishDAO;
import com.example.entity.Fish;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FishServiceImpl implements FishService {
    private final FishDAO fishDAO;

    @Autowired
    public FishServiceImpl (FishDAO fishDAO) {
        this.fishDAO = fishDAO;
    }

    @Override
    public List<Fish> getFishes () {
        return fishDAO.getFishes();
    }

    @Override
    public Fish getFish (int id) {
        return fishDAO.getFish(id);
    }

    @Override
    public void deleteFish (Fish fish) {
        fishDAO.deleteFish(fish);
    }

    @Override
    public void updateFish (Fish fish) {
        fishDAO.updateFish(fish);
    }

    @Override
    public void createFish (Fish fish) {
        fishDAO.createFish(fish);
    }

}
