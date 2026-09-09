package com.example.controller;

import com.example.entity.Bird;
import com.example.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BirdController {
    private final BirdService birdService;

    @Autowired
    public BirdController (BirdService birdService) {
        this.birdService = birdService;
    }


    @GetMapping("/getBirds")
    public String getBirds (Model model) {
        List<Bird> birds = birdService.getBirds();
        model.addAttribute("birds", birds);
        model.addAttribute("title", "home page");
        return "/birds";
    }

    @GetMapping("/getBird")
    public String getBird (Model model, @RequestParam ("id") int id) {
        Bird bird = birdService.getBird(id);
        model.addAttribute("bird", bird);
        model.addAttribute("title", "get bird by id");
        return "/bird";
    }

    @GetMapping ("/deleteBird")
    public String deleteBird (@RequestParam ("id") int id) {
        Bird bird = birdService.getBird(id);
        birdService.deleteBird(bird);
        return "redirect:/getBirds";
    }

    @GetMapping ("/saveBird")
    public String saveBird (Model model) {
        Bird bird = new Bird();
        model.addAttribute("bird", bird);
        model.addAttribute("title", "SAVING NEW BIRD");
        model.addAttribute("url", "/afterSaveBird");
        return "/bird-form";
    }

    @PostMapping("/afterSaveBird")
    public String afterSaveBird (@ModelAttribute("bird") Bird bird) {
        birdService.saveBird(bird);
        return "redirect:/getBird?id="+bird.getId();
    }

    @GetMapping ("/updateBird")
    public String updateBird (Model model, @RequestParam ("id") int id) {
        Bird bird = birdService.getBird(id);
        model.addAttribute("bird", bird);
        model.addAttribute("url", "/afterUpdateBird");
        model.addAttribute("title", "BIRD UPDATING");
        return "/bird-form";
    }

    @PostMapping("/afterUpdateBird")
    public String afterUpdateBird (@ModelAttribute ("bird") Bird bird) {
        birdService.updateBird(bird);
        return "redirect:/getBird?id="+bird.getId();
    }
}
