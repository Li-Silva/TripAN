package com.trips.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.trips.models.Trip;
import com.trips.services.ITripServices;

@Controller
@RequestMapping("/trips")
public class TripController {

    @Autowired
    private ITripServices servicesTrip;

    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idTrip, Model model) {

        Trip trip = servicesTrip.buscarPorId(idTrip);

        System.out.println("IdTrip es: " + idTrip);

        if (trip != null) {
            model.addAttribute("trip", trip);
        } else {
            model.addAttribute("mensaje", "El viaje no existe");
            return "mensaje";
        }

        return "trips/detalle";
    }

    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idTrip, Model model) {

        System.out.println("idTrip es: " + idTrip);

        Trip trip = servicesTrip.buscarPorId(idTrip);

        if (trip != null) {
            model.addAttribute("mensaje", "Viaje eliminado correctamente (simulado)");
        } else {
            model.addAttribute("mensaje", "El viaje no existe");
        }

        return "mensaje";
    }
}

