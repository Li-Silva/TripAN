package com.trips.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaTripController {

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        return "categoriasTrip/listCategoria";
    }

    @GetMapping("/create")
    public String crear() {
        return "categoriasTrip/formCategoria";
    }


    @PostMapping("/save")
    public String guardar(@RequestParam("nombre") String nombre,
                          @RequestParam("descripcion") String descripcion) {

        System.out.println("Nombre Categoria: " + nombre);
        System.out.println("Descripcion: " + descripcion);

        return "redirect:/categorias/index"; 
    }

    //Un parámetro
    @GetMapping("/detalle/{id}")
    public String mostrarDetalle(@PathVariable int id, Model model) {

        model.addAttribute("id", id);

        return "categoriasTrip/detalle";
    }

    // Dos parámetros
    @GetMapping("/detalle/{id}/{fecha}")
    public String mostrarDetalleConFecha(
            @PathVariable int id,
            @PathVariable String fecha,
            Model model) {

        model.addAttribute("id", id);
        model.addAttribute("fecha", fecha);

        return "categoriasTrip/detalle";
    }
}