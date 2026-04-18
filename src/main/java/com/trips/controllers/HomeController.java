package com.trips.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.trips.models.Trip;

import java.util.Date;
import java.util.LinkedList;
import java.text.SimpleDateFormat;
import java.text.ParseException;

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
        model.addAttribute("listadoTrips", getTrip());
        return "listado";
    }

    @GetMapping("/detalle")
    public String mostrarDetalle(Model model) {
        Trip trip = new Trip();
        trip.setNomTrip("Rapel en Volcatenango");
        trip.setDescripcion("Rapel en un circuito conectado en las...");
        trip.setFecha(new Date());
        trip.setCosto(10.0);

        model.addAttribute("trip", trip);

        return "detalle";
    }


    private List<Trip> getTrip() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        List<Trip> lista = new LinkedList<>();

        try {
            Trip trip1 = new Trip();
            trip1.setId(1);
            trip1.setNomTrip("Rapel en Volcatenango");
            trip1.setDescripcion("Hacer rapel en los circuitos de Volcatenango");
            trip1.setFecha(sdf.parse("10-05-2026"));
            trip1.setCosto(5.0);
            trip1.setDestacado(1);
            trip1.setImagen("trip01.png");
            
            Trip trip2 = new Trip();
            trip2.setId(2);
            trip2.setNomTrip("Deslizadero en El Picnic");
            trip2.setDescripcion("Deslízate en un divertido tobogán sobre la colina");
            trip2.setFecha(sdf.parse("10-05-2026"));
            trip2.setCosto(5.0);
            trip2.setImagen("trip02.png");

            Trip trip3 = new Trip();
            trip3.setId(3);
            trip3.setNomTrip("Comida y Flores");
            trip3.setDescripcion("Disfruta de un amplio jardín donde podrás comprar");
            trip3.setFecha(sdf.parse("10-05-2026"));
            trip3.setCosto(1.0);
            trip3.setImagen("trip03.png");

            Trip trip4 = new Trip();
            trip4.setId(4);
            trip4.setNomTrip("Caminatas");
            trip4.setDescripcion("Disfruta hacer senderismo en Chalatenango");
            trip4.setFecha(sdf.parse("10-05-2026"));
            trip4.setCosto(1.0);
            trip4.setImagen("trip04.png");


            lista.add(trip1);
            lista.add(trip2);
            lista.add(trip3);
            lista.add(trip4);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return lista;
    }
    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
    	List<Trip> lista = getTrip();
    	model.addAttribute("listadoTrips", lista);
    	return "tabla";
    	
    	
    }
}