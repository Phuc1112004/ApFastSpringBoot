package com.example.apfastspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.apfastspringboot.entity.Vehicle;
import com.example.apfastspringboot.repository.VehicleRepository;
import com.example.apfastspringboot.service.VehicleService;

import java.util.Optional;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public String getAllVehicles(Model model) {
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        return "vehicles";
    }

    @GetMapping("/{id}")
    public String getVehicleDetails(@PathVariable Long id, Model model) {
        Optional<Vehicle> vehicle = vehicleService.getVehicleById(String.valueOf(id));
        model.addAttribute("vehicle", vehicle);
        return "vehicle-details";
    }

    @GetMapping("/new")
    public String showNewVehicleForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "new-vehicle";
    }

    @PostMapping
    public String saveVehicle(@ModelAttribute Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);
        return "redirect:/vehicles";
    }

    @GetMapping("/edit/{id}")
    public String showEditVehicleForm(@PathVariable Long id, Model model) {
        Optional<Vehicle> vehicle = vehicleService.getVehicleById(String.valueOf(id));
        model.addAttribute("vehicle", vehicle);
        return "edit-vehicle";
    }

    @PostMapping("/{id}")
    public String updateVehicle(@PathVariable Long id, @ModelAttribute Vehicle vehicle) {
        vehicle.setVehicleId(String.valueOf(id));
        vehicleService.saveVehicle(vehicle);
        return "redirect:/vehicles";
    }

    @GetMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(String.valueOf(id));
        return "redirect:/vehicles";
    }
}
