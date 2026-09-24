package com.example.service;

import com.example.dao.TomDAO;
import com.example.entity.Tom;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TomServiceImpl implements TomService {
    private final TomDAO tomDAO;
    @Autowired
    public TomServiceImpl (TomDAO tomDAO) {
        this.tomDAO = tomDAO;
    }

    @Override
    public Tom getTom (int id) {
        return tomDAO.getTom(id);
    }

    @Override
    public List<Tom> getToms () {
        return tomDAO.getToms();
    }

    @Override
    public void createTom (Tom tom) {
        tomDAO.createTom(tom);
    }

    @Override
    public void deleteTom (Tom tom) {
        tomDAO.deleteTom(tom);
    }

    @Override
    public void updateTom (Tom tom) {
        tomDAO.deleteTom(tom);
    }
}
