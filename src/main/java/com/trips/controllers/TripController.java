package com.trips.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trips")
public class TripController {

    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idTrip, Model model) {

        System.out.println("IdTrip es: " + idTrip);

        model.addAttribute("idTrip", idTrip); 

        return "trips/detalle";
    }
    
    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idTrip, Model model) {

        System.out.println("idTrip es: " + idTrip);

        model.addAttribute("id", idTrip); 

        return "mensaje"; 
    }
}

