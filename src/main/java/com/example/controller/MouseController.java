package com.example.controller;

import com.example.entity.Mouse;
import com.example.service.MouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MouseController {

    private final MouseService mouseService;

    @Autowired
    public MouseController (MouseService mouseService) {
        this.mouseService = mouseService;
    }

    @GetMapping("/micePage")
    public String micePage (Model model) {
        List<Mouse> mice = mouseService.getMice();
        model.addAttribute("mice", mice);
        return "mice";
    }

    @GetMapping ("/showMouse")
    public String showMouse (Model model, @RequestParam ("id") int id) {
        Mouse mouse = mouseService.findMouse(id);
        model.addAttribute("mouse", mouse);
        return "mouse";
    }

    @GetMapping ("/deleteMouse")
    public String deleteMouse (@RequestParam ("id") int id) {
        Mouse mouse = mouseService.findMouse(id);
        mouseService.deleteMouse(mouse);
        return "redirect:/micePage";
    }

    @GetMapping ("/createMouse")
    public String createMouse (Model model) {
        Mouse mouse = new Mouse();
        model.addAttribute("url", "/afterCreateMouse");
        model.addAttribute("title", "AFTER CREATE MOUSE");
        model.addAttribute("mouse", mouse);
        return "/mouse-form";
    }

    @PostMapping ("/afterCreateMouse")
        public String afterCreateMouse (@ModelAttribute ("mouse") Mouse mouse) {
        mouseService.createMouse(mouse);
        return "redirect:/showMouse?id="+mouse.getId();
    }

    @GetMapping ("/updateMouse")
    public String updateMouse (Model model, @RequestParam ("id") int id) {
        Mouse mouse = mouseService.findMouse(id);
        model.addAttribute("title", "AFTER UPDATE MOUSE");
        model.addAttribute("mouse", mouse);
        model.addAttribute("url", "/afterUpdateMouse");
        return "/mouse-form";
    }

    @PostMapping ("/afterUpdateMouse")
    public String afterUpdateMouse (Model model, @ModelAttribute ("mouse") Mouse mouse) {
        mouseService.updateMouse(mouse);
        return "redirect:/showMouse?id="+mouse.getId();
    }
}
