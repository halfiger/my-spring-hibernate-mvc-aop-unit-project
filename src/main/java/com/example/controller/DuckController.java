package com.example.controller;

import com.example.entity.Duck;
import com.example.service.DuckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DuckController {
    private final DuckService duckService;

    @Autowired
    public DuckController (DuckService duckService) {
        this.duckService = duckService;
    }

    @GetMapping("/getAllDucks")
    public String getAllDucks (Model model) {
        List<Duck> ducks = duckService.getAllDucks();
        model.addAttribute("ducks", ducks);
        return "/ducks";
    }

    @GetMapping ("/getDuck")
    public String getDuck (Model model, @RequestParam("id") int id) {
        Duck duck = duckService.getDuck(id);
        model.addAttribute("duck", duck);
        return "duck";
    }

    @GetMapping ("/deleteDuck")
    public String deleteDuck (@RequestParam("id") int id) {
        Duck duck = duckService.getDuck(id);
        duckService.removeDuck(duck);
        return "redirect:/getAllDucks";
    }

    @GetMapping ("/createDuck")
    public String createDuck (Model model) {
        Duck duck = new Duck();
        model.addAttribute("duck", duck);
        model.addAttribute("title", "CREATE");
        model.addAttribute("url", "/afterCreateDuck");
        return "/duck-form";
    }

    @PostMapping ("/afterCreateDuck")
    public String afterCreateDuck (@ModelAttribute ("Duck") Duck duck) {
        duckService.createDuck(duck);
        return "redirect:/getDuck?id="+ duck.getId();
    }

    @GetMapping ("/updateDuck")
    public String updateDuck (Model model, @RequestParam ("id") int id) {
        Duck duck = duckService.getDuck(id);
        model.addAttribute("duck", duck);
        model.addAttribute("title", "UPDATE");
        model.addAttribute("url", "/afterUpdateDuck");
        return "/duck-form";
    }

    @PostMapping ("/afterUpdateDuck")
    public String afterUpdateDuck (Model model, @ModelAttribute ("Duck") Duck duck) {
        duckService.updateDuck(duck);
        return "redirect:/getDuck?id="+ duck.getId();
    }
 }