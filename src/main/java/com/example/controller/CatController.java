package com.example.controller;

import com.example.dao.CatDAO;
import com.example.entity.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CatController {

    private final CatDAO catDAO;

    @Autowired
    public CatController (CatDAO catDAO) {
        this.catDAO = catDAO;
    }

    @GetMapping ("/cat-home")
    public String getAllCats (Model model) {
        List<Cat> cats = catDAO.getCats();
        model.addAttribute("cats", cats);
        return "cats";
    }

    @GetMapping ("/cat-find")
    public String getCat (Model model, @RequestParam ("id") int id) {
        Cat cat = catDAO.getCat(id);
        model.addAttribute(cat);
        return "cat";
    }

    @GetMapping ("/cat-delete")
    public String deleteCat (@RequestAttribute ("cat") Cat cat) {
        catDAO.deleteCat(cat);
        return "redirect:/cat-home";
    }

    @GetMapping ("/cat-save")
    public String saveCat (Model model) {
        Cat cat = new Cat();
        model.addAttribute("cat", cat);
        return "cat-form";
    }

    @GetMapping ("/cat-update")
    public String updateCat (Model model, @RequestParam ("id") int id) {
        Cat cat = catDAO.getCat(id);
        model.addAttribute(cat);
        return "cat-form";
    }


}