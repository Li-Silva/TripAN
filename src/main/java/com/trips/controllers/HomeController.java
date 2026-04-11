package com.trips.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@Controller
public class HomeController {

    @GetMapping("/")
    public String mostrarHome(Model model) {

        model.addAttribute("trip", "Rapel en el Volcan");
        model.addAttribute("fechaPublicacion", new Date());
        model.addAttribute("costo", 5.0);
        model.addAttribute("vigente", true);

        return "home";
    }
}
