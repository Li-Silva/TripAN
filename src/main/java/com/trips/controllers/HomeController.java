package com.trips.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.LinkedList;

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
    @GetMapping("/listado")
    public String mostrarListado(Model model) {
    	
    	List<String> lista = new LinkedList<String>();
    	lista.add("En la montana");
    	lista.add("En la ciudad");
    	lista.add("En los pueblos");
    	lista.add("En las playas");
    	
    	model.addAttribute("listadoTrips", lista);
    	
    	return "listado";
    	
    }
}
