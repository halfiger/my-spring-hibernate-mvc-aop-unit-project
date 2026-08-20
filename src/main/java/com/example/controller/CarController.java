package com.example.controller;

import com.example.entity.Car;
import com.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/showAllCars")
    public String getAllCars(Model model) {
        List<Car> list = carService.findAll();
        model.addAttribute("cars", list);
        return "cars";
    }

    @GetMapping("/showCarById")
    public String showCarById(@RequestParam("id") int id, Model model) {
        Car car = carService.findById(id);
        model.addAttribute("car", car);
        return "car";
    }

    @GetMapping("/createNewCar")
    public String createNewCar(Model model) {
        model.addAttribute("url", "afterCreateNewCar");
        model.addAttribute("car", new Car());
        return "car-form";
    }

    @PostMapping("/afterCreateNewCar")
    public String afterCreateNewCar(@ModelAttribute("car") Car car) {
        carService.save(car);
        return "redirect:/showCarById?id=" + car.getId();
    }

    @GetMapping("/updateExistedCar")
    public String updateExistedCar(@RequestParam("id") int id, Model model) {
        model.addAttribute("url", "afterUpdateExistingCar");
        model.addAttribute("car", carService.findById(id));
        return "car-form";
    }

    @PostMapping("/afterUpdateExistingCar")
    public String afterUpdateExistingCar(@ModelAttribute("car") Car car) {
        carService.update(car);
        return "redirect:/showCarById?id=" + car.getId();
    }

    @GetMapping("/deleteCarById")
    public String updateCar(@RequestParam("id") int id) {
        carService.deleteById(id);
        return "redirect:/showAllCars";
    }

}
