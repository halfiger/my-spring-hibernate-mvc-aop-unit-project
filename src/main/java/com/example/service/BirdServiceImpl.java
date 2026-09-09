package com.example.service;

import com.example.dao.BirdDAO;
import com.example.entity.Bird;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class BirdServiceImpl implements BirdService{

    private final BirdDAO birdDAO;

    @Autowired
    public BirdServiceImpl (BirdDAO birdDAO) {
        this.birdDAO = birdDAO;
    }

    @Override
    public Bird getBird (int id) {
        return birdDAO.getBird(id);
    }

    @Override
    public List<Bird> getBirds () {
        return birdDAO.getBirds();
    }

    @Override
    public void updateBird (Bird bird) {
        birdDAO.updateBird(bird);
    }

    @Override
    public void deleteBird (Bird bird) {
        birdDAO.deleteBird(bird);
    }

    @Override
    public void saveBird (Bird bird) {
        birdDAO.saveBird(bird);
    }



}
