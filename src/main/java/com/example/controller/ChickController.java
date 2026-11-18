package com.example.controller;

import com.example.entity.Chick;
import com.example.service.ChickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getChick")
    public String getChick(@RequestParam("id") int id, Model model) {
        Chick chick = chickService.getChick(id);
        model.addAttribute("chick", chick);
        return "/chick";
    }

    @GetMapping ("createChick")
    public String createChick (Model model) {
    Chick chick = new Chick();
    model.addAttribute("chick", chick);
    model.addAttribute("mode", "Create");
    model.addAttribute("url", "/afterCreateChick");
    return "/chick-form";
    }

    @GetMapping ("deleteChick")
    public String deleteChick (@RequestParam ("id") int id) {
        Chick chick = chickService.getChick(id);
        chickService.removeChick(chick);
        return "redirect:/getAllChicks";
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
    public String afterCreateChick (@ModelAttribute("chick") Chick chick) {
        chickService.createChick(chick);
        return "redirect:/getChick?id="+chick.getId();
    }

    @PostMapping ("afterUpdateChick")
    public String afterUpdateChick (@ModelAttribute("chick") Chick chick) {
    chickService.updateChick(chick);
    return "redirect:/getChick?id="+chick.getId();
    }

}
