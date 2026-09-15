package com.example.controller;

import com.example.entity.Fish;
import com.example.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FishController {

    private final FishService fishService;
    @Autowired
    public FishController (FishService fishService) {
        this.fishService = fishService;
    }

    @GetMapping ("/showFishes")
    public String showFishes (Model model) {
        List<Fish> list = fishService.getFishes();
        model.addAttribute("fishes", list);
        return "fishes";
    }

    @GetMapping ("/showFish")
    public String showFish (Model model, @RequestParam ("id") int id) {
        Fish fish = fishService.getFish(id);
        model.addAttribute("fish", fish);
        return "fish";
    }

    @GetMapping ("/deleteFish")
    public String deleteFish (Model model, @RequestParam ("id") int id) {
        Fish fish = fishService.getFish(id);
        fishService.deleteFish(fish);
        return "redirect:/showFishes";
    }

    @GetMapping ("/createFish")
    public String createFish (Model model) {
        Fish fish = new Fish();
        model.addAttribute("fish", fish);
        model.addAttribute("title", "CREATE");
        model.addAttribute("url", "/afterCreateFish");
        return "fish-form";
    }

    @PostMapping("/afterCreateFish")
    public String afterCreateFish (@ModelAttribute ("fish") Fish fish) {
        fishService.createFish(fish);
        return "redirect:/showFish?id="+fish.getId();
    }

    @GetMapping ("/updateFish")
    public String updateFish (Model model, @RequestParam ("id") int id) {
        Fish fish = fishService.getFish(id);
        model.addAttribute("fish", fish);
        model.addAttribute("title", "UPDATE");
        model.addAttribute("url", "/afterUpdateFish");
        return "fish-form";
    }

    @PostMapping ("/afterUpdateFish")
    public String afterUpdateFish (@ModelAttribute ("fish") Fish fish) {
        fishService.updateFish(fish);
        return "redirect:/showFish?id="+fish.getId();
    }
}
