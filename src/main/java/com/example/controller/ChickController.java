package com.example.controller;

import com.example.entity.Chick;
import com.example.service.ChickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ChickController {

private final ChickService chickService;

@Autowired
    public ChickController (ChickService chickService) {
    this.chickService = chickService;
}

    @GetMapping ("/getAllChicks")
    public String getAllChicks (Model model) {
    List<Chick> chicks = chickService.getChicks();
    model.addAttribute("chicks", chicks);
    return "/chicks";
    }

    @GetMapping ("/getChick")
    public String getChick (int id, Model model) {
    Chick chick = chickService.getChick(id);
    model.addAttribute("chick", chick);
    return "/chick";
    }

    @GetMapping ("deleteChick")
    public String deleteChick (@RequestParam ("id") int id) {
    Chick chick = chickService.getChick(id);
    chickService.removeChick(chick);
    return "redirect:/getAllChicks";
    }

    @GetMapping ("createChick")
    public String createChick (Model model) {
    Chick chick = new Chick();
    model.addAttribute("chick", chick);
    model.addAttribute("mode", "Create");
    model.addAttribute("url", "/afterCreateChick");
    return "/chick-form";
    }

    @GetMapping ("updateChick")
    public String updateChick (Model model, @RequestParam ("id") int id) {
        Chick chick = chickService.getChick(id);
        model.addAttribute("chick", chick);
        model.addAttribute("mode", "update");
        model.addAttribute("url", "/afterUpdateChick");
        return "/chick-form";
    }

    @PostMapping ("afterCreateChick")
    public String afterCreateChick (@RequestAttribute ("Chick") Chick chick) {
        chickService.createChick(chick);
        return "redirect:/chick?id="+chick.getId();
    }

    @PostMapping ("afterUpdateChick")
    public String afterUpdateChick (@RequestParam ("Chick") Chick chick) {
    chickService.updateChick(chick);
    return "redirect:/chick?id="+chick.getId();
    }

}
