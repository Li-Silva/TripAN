package com.trips.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.trips.models.Trip;
import com.trips.services.IRolService;



	@Controller
	@RequestMapping("/Rol")
	public class RolController {
	    @Autowired
	    private IRolService rolService;

	    //  HOME (lista principal)
	    @GetMapping("/")
	    public String mostrarHome(Model model) {
	        List<Trip> lista = rolService.buscarTodo();
	        model.addAttribute("roles", lista);
	        return "home";
	    }

	    // LISTADO 
	    @GetMapping("/listadorol")
	    public String mostrarListado(Model model) {
	        List<Trip> lista = rolService.buscarTodo();
	        model.addAttribute("roles", lista); 
	        return "listadorol";
	    }

	    // DETALLE REAL POR ID
	    @GetMapping("/detallerol/{id}")
	    public String mostrarDetalle(@PathVariable("id") Integer id, Model model) {

	    	Trip rol = rolService.buscarPorId(id);

	        if (rol != null) {
	            model.addAttribute("roles", rol);
	            return "detallerol";
	        } else {
	            model.addAttribute("mensaje", "El viaje no existe");
	            return "mensaje";
	        }
	    }

	    //TABLA 
	    @GetMapping("/rol")
	    public String mostrarTabla(Model model) {
	        List<Trip> lista = rolService.buscarTodo();
	        model.addAttribute("roles", lista);
	        return "roles";
	    }
	}
