package com.example.controller;

import com.example.entity.Tom;
import com.example.service.TomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TomController {
    private final TomService tomService;

    @Autowired
    public TomController (TomService tomService) {
        this.tomService = tomService;
    }

    @GetMapping("/getToms")
    public String getToms (Model model) {
        List<Tom> toms = tomService.getToms();
        model.addAttribute ("toms", toms);
        return "/toms";
    }

    @GetMapping ("/getTom")
    public String getTom (@RequestParam("id") int id, Model model) {
        Tom tom = tomService.getTom(id);
        model.addAttribute("tom", tom);
        return "/tom";
    }

    @GetMapping ("deleteTom")
    public String deleteTom (@RequestParam ("id") int id) {
        Tom tom = tomService.getTom(id);
        tomService.deleteTom(tom);
        return "redirect:/getToms";
    }

    @GetMapping ("/createTom")
    public String crerateTom (Model model) {
        Tom tom = new Tom();
        model.addAttribute("tom", tom);
        model.addAttribute("url", "/afterCreateTom");
        return "tom-form";
    }

    @PostMapping ("afterCreateTom")
    public String afterCreateTom (@RequestAttribute ("tom") Tom tom) {
        tomService.createTom(tom);
        return "redirect:/getTom?id="+tom.getId();
    }

    @GetMapping
    private String updateTom (@RequestParam ("id") int id, Model model) {
        Tom tom = tomService.getTom(id);
        model.addAttribute("tom", tom);
        model.addAttribute("url", "afterUpdateTom");
        return "tom-form";
    }

    @PostMapping
    private String afterUpdateTom (@RequestAttribute ("tom") Tom tom) {
        tomService.updateTom(tom);
        return "redirect:/getTom?id="+tom.getId();
    }

}
