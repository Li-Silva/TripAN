package com.trips.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.trips.models.Trip;
import com.trips.services.ITripServices;

@Controller
public class HomeController {

    @Autowired
    private ITripServices tripService;

    //  HOME (lista principal)
    @GetMapping("/")
    public String mostrarHome(Model model) {
        List<Trip> lista = tripService.buscarTodo();
        model.addAttribute("trips", lista);
        return "home";
    }

    // LISTADO 
    @GetMapping("/listado")
    public String mostrarListado(Model model) {
        List<Trip> lista = tripService.buscarTodo();
        model.addAttribute("trips", lista); 
        return "listado";
    }

    // DETALLE REAL POR ID
    @GetMapping("/detalle/{id}")
    public String mostrarDetalle(@PathVariable("id") Integer id, Model model) {

        Trip trip = tripService.buscarPorId(id);

        if (trip != null) {
            model.addAttribute("trip", trip);
            return "detalle";
        } else {
            model.addAttribute("mensaje", "El viaje no existe");
            return "mensaje";
        }
    }

    //TABLA 
    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Trip> lista = tripService.buscarTodo();
        model.addAttribute("trips", lista);
        return "tabla";
    }
}
