package com.trips.services;

import java.util.List;

import com.trips.models.Trip;


public interface IRolService {
	
    List<Trip> buscarTodo();
    Trip buscarPorId(Integer idRol);

}
