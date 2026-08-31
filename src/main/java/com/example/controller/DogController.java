package com.example.controller;

import com.example.entity.Dog;
import com.example.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "show-dog";
    }

    @GetMapping ("/create-dog")
    public String createDog (Model model) {
        model.addAttribute("dog", new Dog());
        model.addAttribute("url", "/afterCreate");
        return "dog-form";
    }

    @GetMapping ("/update-dog")
    public String updateDog (Model model, @RequestParam ("id") int id) {
        Dog dog = dogService.showDog(id);
        model.addAttribute("dog", dog);
        model.addAttribute("url", "/afterUpdate");
        return "dog-form";
    }

    @GetMapping ("/delete-dog")
    public String deleteDog (@RequestAttribute ("Dog") Dog dog) {
        dogService.delete(dog);
        return "redirect:/show-dogs";
    }
}