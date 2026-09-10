package com.example.service;

import com.example.dao.FrogDAO;
import com.example.entity.Frog;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class FrogServiceImpl implements FrogService {

    private final FrogDAO frogDAO;

    @Autowired
    public FrogServiceImpl (FrogDAO frogDAO) {
        this.frogDAO = frogDAO;
    }

    public Frog getFrog (int id) {
        return frogDAO.getFrog(id);
    }

    public List<Frog> getFrogs() {
        return frogDAO.getFrogs();
    }

    public void updateFrog (Frog frog) {
        frogDAO.updateFrog(frog);
    }

    public void createFrog (Frog frog) {
        frogDAO.createFrog(frog);
    }

    public void deleteFrog (Frog frog) {
        frogDAO.deleteFrog(frog);
    }
}
