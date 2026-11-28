package com.example.controller;

import com.example.entity.Yoda;
import com.example.service.YodaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class YodaController {
    private final YodaService yodaService;

    public YodaController (YodaService yodaService) {
        this.yodaService = yodaService;
    }

    @GetMapping ("/getAllYodas")
    public String getAllYodas (Model model) {
        List<Yoda> list = yodaService.getAllYodas();
        model.addAttribute("yodas", list);
        return "yodas";
    }

    @GetMapping ("/getYoda")
    public String getYoda (Model model, @RequestParam ("id") int id) {
        Yoda yoda = yodaService.getYoda(id);
        model.addAttribute("yoda", yoda);
        return "yoda";
    }

    @GetMapping ("/createYoda")
    public String createYoda (Model model) {
        Yoda yoda = new Yoda();
        model.addAttribute("yoda", yoda);
        model.addAttribute("url", "/afterCreateYoda");
        return "yoda-form";
    }

    @GetMapping ("/deleteYoda")
    public String deleteYoda (@RequestParam ("id") int id) {
        Yoda yoda = yodaService.getYoda(id);
        yodaService.deleteYoda(yoda);
        return "redirect:/getAllYodas";
    }

    @GetMapping ("/updateYoda")
    public String updateYoda (Model model, @RequestParam ("id") int id) {
        Yoda yoda = yodaService.getYoda(id);
        yodaService.updateYoda(yoda);
        model.addAttribute("yoda", yoda);
        model.addAttribute("url", "/afterUpdateYoda");
        return "yoda-form";
    }

    @PostMapping ("/afterCreateYoda")
    public String afterCreateYoda (@ModelAttribute ("Yoda") Yoda yoda) {
        yodaService.createYoda(yoda);
        return "redirect:/getYoda?id="+yoda.getId();
    }

    @PostMapping ("/afterUpdateYoda")
    public String afterUpdateYoda (@ModelAttribute ("yoda") Yoda yoda) {
        yodaService.updateYoda(yoda);
        return "redirect:/getYoda?id="+yoda.getId();
    }
}
