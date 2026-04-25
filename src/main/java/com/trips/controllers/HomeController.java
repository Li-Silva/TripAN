package com.trips.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.trips.models.Trip;
import com.trips.services.ITripServices;

@Controller
public class HomeController {

    @Autowired
    private ITripServices tripService;

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
        List<Trip> lista = tripService.buscarTodo();
        model.addAttribute("listadoTrips", lista);
        return "listado";
    }

    @GetMapping("/detalle")
    public String mostrarDetalle(Model model) {
        Trip trip = new Trip();
        trip.setNomTrip("Rapel en Volcatenango");
        trip.setDescripcion("Rapel en un circuito...");
        trip.setFecha(new Date());
        trip.setCosto(10.0);

        model.addAttribute("trip", trip);
        return "detalle";
    }

    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Trip> lista = tripService.buscarTodo();
        model.addAttribute("listadoTrips", lista);
        return "tabla";
    }
}
