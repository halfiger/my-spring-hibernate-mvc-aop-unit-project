package com.example.controller;

import com.example.entity.Animal;
import com.example.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController (AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/findAnimal")
    public String findAnimal (@RequestParam ("id") int id, Model model) {
        Animal animal = animalService.findById(id);
        model.addAttribute("animal", animal);
        return "animal";
    }

    @GetMapping ("/findAllAnimals")
    public String findAllAnimals (Model model) {
        List <Animal> list = animalService.findAll();
        model.addAttribute("Animals", list);
        return "animals";
    }

    @GetMapping("/deleteAnimal")
    public String delete (@RequestParam ("id") int id) {
        animalService.delete(id);
        return "redirect:/findAllAnimals";
    }

    @GetMapping("/createAnimal")
    public String createAnimal (Model model) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("url", "afterCreateAnimal");
        return "animal-form";
    }

    @PostMapping ("/afterCreateAnimal")
    public String afterCreateAnimal (@ModelAttribute ("animal") Animal animal) {
        animalService.save(animal);
        return "redirect:/findAnimal?id=" + animal.getId();
    }

    @GetMapping ("/updateAnimal")
    public String updateAnimal (Model model, @RequestParam ("id") int id) {
        Animal animal = animalService.findById(id);
        model.addAttribute("animal", animal);
        model.addAttribute("url", "afterUpdateAnimal");
        return "animal-form";
    }

    @PostMapping ("afterUpdateAnimal")
    public String afterUpdateAnimal (@ModelAttribute ("animal") Animal animal) {
        animalService.update(animal);
        return "redirect:/findAnimal?id=" + animal.getId();
    }

}
