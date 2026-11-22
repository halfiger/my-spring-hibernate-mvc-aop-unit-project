package com.example.service;

import com.example.dao.YodaDAO;
import com.example.entity.Yoda;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class YodaServiceImpl {
    private final YodaDAO yodaDAO;

    public YodaServiceImpl (YodaDAO yodaDAO) {
        this.yodaDAO = yodaDAO;
    }

    public List<Yoda> getAllYodas () {
        return yodaDAO.getAllYodas();
    }

    public Yoda getYoda (int id) {
        return yodaDAO.getYoda(id);
    }
   public void createYoda (Yoda yoda) {
        yodaDAO.createYoda(yoda);
   }

   public void deleteYoda (Yoda yoda) {
        yodaDAO.deleteYoda(yoda);
   }

   public void updateYoda (Yoda yoda) {
        yodaDAO.updateYoda(yoda);
   }



}
