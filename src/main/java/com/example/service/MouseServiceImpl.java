package com.example.service;

import com.example.dao.MouseDAO;
import com.example.entity.Mouse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class MouseServiceImpl implements MouseService {

    private final MouseDAO mouseDAO;

    @Autowired
    public MouseServiceImpl(MouseDAO mouseDAO) {
        this.mouseDAO = mouseDAO;
    }

    @Override
    public Mouse findMouse(int id) {
        return mouseDAO.findMouse(id);
    }

    @Override
    public List<Mouse> getMice() {
        return mouseDAO.getMice();
    }

    @Override
    public void deleteMouse(Mouse mouse) {
        mouseDAO.deleteMouse(mouse);
    }

    @Override
    public void updateMouse(Mouse mouse) {
        mouseDAO.updateMouse(mouse);
    }

    @Override
    public void createMouse(Mouse mouse) {
        mouseDAO.createMouse(mouse);
    }


}
