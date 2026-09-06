package com.example.service;

import com.example.dao.CatDAO;
import com.example.entity.Cat;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CatServiceImpl implements CatService {

    private final CatDAO catDAO;

    @Autowired
    public CatServiceImpl (CatDAO catDAO) {
        this.catDAO = catDAO;
    }

    @Override
    public Cat getCat (int id) {
        return catDAO.getCat(id);
    }

    @Override
    public List<Cat> getCats () {
        return catDAO.getCats();
    }

    @Override
    public void deleteCat (Cat cat) {
        catDAO.deleteCat(cat);
    }

    @Override
    public void saveCat (Cat cat) {
        catDAO.saveCat(cat);
    }

    @Override
    public void updateCat (Cat cat) {
        catDAO.updateCat(cat);
    }
}