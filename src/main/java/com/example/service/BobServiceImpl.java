package com.example.service;

import com.example.dao.BobDAO;
import com.example.entity.Bob;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BobServiceImpl implements BobService {
    private final BobDAO bobDAO;

    @Autowired
    public BobServiceImpl (BobDAO bobdao) {
        this.bobDAO = bobdao;
    }

    public Bob getBob (int id) {
        return bobDAO.getBob(id);
    }

    public List<Bob> getBobs () {
        return bobDAO.getBobs();
    }

    public void createBob (Bob bob) {
        bobDAO.createBob(bob);
    }

    public void updateBob (Bob bob) {
        bobDAO.updateBob(bob);
    }

    public void deleteBob (Bob bob) {
        bobDAO.deleteBob(bob);
    }
}
