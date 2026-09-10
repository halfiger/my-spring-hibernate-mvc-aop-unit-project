package com.example.controller;

import com.example.entity.Frog;
import com.example.service.FrogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FrogController {

    private final FrogService frogService;

    @Autowired
    public FrogController (FrogService frogService) {
        this.frogService = frogService;
    }

    @GetMapping ("/getFrogs")
    public String getFrogs (Model model) {
        List<Frog> frogs = frogService.getFrogs();
        model.addAttribute("frogs", frogs);
        return "/frogs";
    }

    @GetMapping ("/getFrog")
    public String getFrog (@RequestParam ("id") int id, Model model) {
        Frog frog = frogService.getFrog(id);
        model.addAttribute("frog", frog);
        return "/frog";
    }

    @GetMapping ("/deleteFrog")
    public String deleteFrog (@RequestParam ("id") int id) {
        Frog frog = frogService.getFrog(id);
        frogService.deleteFrog(frog);
        return "redirect:/getFrogs";
    }

    @GetMapping ("/updateFrog")
    public String updateFrog (@RequestParam ("id") int id, Model model) {
        Frog frog = frogService.getFrog(id);
        model.addAttribute("frog", frog);
        model.addAttribute("title", "UPDATE FROG");
        model.addAttribute("url", "/afterUpdateFrog");
        return "/frog-form";
    }

    @PostMapping ("/afterUpdateFrog")
    public String afterUpdateFrog (@ModelAttribute ("frog") Frog frog) {
        frogService.updateFrog(frog);
        return "redirect:/getFrog?id="+frog.getId();
    }

    @GetMapping ("/createFrog")
    public String createFrog (Model model) {
        Frog frog = new Frog();
        model.addAttribute("frog", frog);
        model.addAttribute("title", "CREATE FROG");
        model.addAttribute("url", "/afterCreateFrog");
        return "/frog-form";
    }

    @PostMapping("/afterCreateFrog")
    public String afterCreateFrog (@ModelAttribute ("frog") Frog frog) {
        frogService.createFrog(frog);
        return "redirect:/getFrog?id="+frog.getId();
    }
}
