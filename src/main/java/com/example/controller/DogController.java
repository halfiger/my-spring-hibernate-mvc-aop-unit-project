package com.example.controller;

import com.example.entity.Dog;
import com.example.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DogController {

    private final DogService dogService;

    @Autowired
    public DogController (DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/show-dogs")
    public String showDogs (Model model) {
        List<Dog> dogs = dogService.showAll();
        model.addAttribute("dogs", dogs);
        return "dogs";
    }

    @GetMapping ("/show-dog")
    public String showDog (Model model, @RequestParam ("id") int id) {
        Dog dog = dogService.showDog(id);
        model.addAttribute("dog", dog);
        return "dog";
    }

    @GetMapping ("/create-dog")
    public String createDog (Model model) {
        model.addAttribute("dog", new Dog());
        model.addAttribute("url", "/after-create-dog");
        return "dog-form";
    }

    @PostMapping ("/after-create-dog")
    public String afterCreateDog (@ModelAttribute ("dog") Dog dog) {
        dogService.save(dog);
        return "redirect:/show-dog?id="+dog.getId();
    }

    @GetMapping ("/update-dog")
    public String updateDog (Model model, @RequestParam ("id") int id) {
        Dog dog = dogService.showDog(id);
        model.addAttribute("dog", dog);
        model.addAttribute("url", "/after-update-dog");
        return "dog-form";
    }

    @PostMapping ("/after-update-dog")
    public String afterUpdateDog (@ModelAttribute("dog") Dog dog) {
        dogService.update(dog);
        return "redirect:/show-dog?id="+dog.getId();
    }

    @GetMapping ("/delete-dog")
    public String deleteDog (@RequestParam ("id") int id) {

        Dog dog = dogService.showDog(id);
        dogService.delete(dog);
        return "redirect:/show-dogs";
    }
}