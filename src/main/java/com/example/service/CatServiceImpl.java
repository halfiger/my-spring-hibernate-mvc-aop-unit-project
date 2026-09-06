package com.example.service;

import com.example.dao.CatDAO;
import com.example.entity.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {
    @Autowired
    private final CatDAO catDAO;

    public CatServiceImpl (CatDAO catDAO) {
        this.catDAO = catDAO;
    }

    public Cat getCat (int id) {
        return catDAO.getCat(id);
    }

    public List<Cat> getCats () {
        return catDAO.getCats();
    }

    public void deleteCat (Cat cat) {
        catDAO.deleteCat(cat);
    }

    public void saveCat (Cat cat) {
        catDAO.saveCat(cat);
    }

    public void updateCat (Cat cat) {
        catDAO.updateCat(cat);
    }
}