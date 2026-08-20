package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/show")
    public String showUser (@RequestParam("id") int id, Model model) {
        User user = userService.findByID(id);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/create")
    public String saveUser (Model model) {
        model.addAttribute("info", "ADD NEW USER");
        model.addAttribute("url", "afterCreate");
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/afterCreate")
    public String afterSaveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/show?id=" + user.getId();
    }







    @GetMapping ("/update")
    public String updateUser (@RequestParam("id") int id, Model model) {
        model.addAttribute("info", "UPDATE PAGE");
        model.addAttribute("url", "afterUpdate");
        model.addAttribute("user", userService.findByID(id));
        return "user-form";
    }

    @PostMapping("/afterUpdate")
    public String afterUpdateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/show?id="+user.getId();
    }

    @GetMapping("/home")
    public String showUsers (Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/delete")
    public String deleteUser (@RequestParam("id") int id) {
        userService.deleteById(id);
        return "redirect:/home";
    }
}