package com.example.service;

import com.example.dao.ChickDAOImpl;
import com.example.entity.Chick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChickServiceImpl implements ChickService {

    private final ChickDAOImpl chickDAOImpl;

    @Autowired
    public ChickServiceImpl (ChickDAOImpl chickDAOImpl) {
        this.chickDAOImpl = chickDAOImpl;
    }

    public List<Chick> getChicks () {
        return chickDAOImpl.getChicks();
    }

    public Chick getChick (int id) {
        return chickDAOImpl.getChick(id);
    }

    public void createChick (Chick chick) {
        chickDAOImpl.createChick(chick);
    }

    public void removeChick (Chick chick) {
        chickDAOImpl.removeChick(chick);
    }

    public void updateChick (Chick chick) {
        chickDAOImpl.updateChick(chick);
    }
}
