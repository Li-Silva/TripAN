package com.trips.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.trips.models.Trip;

@Service
public class TripServiceImpl implements ITripServices {

    private List<Trip> lista;

    public TripServiceImpl() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        lista = new LinkedList<>();

        try {
            Trip trip1 = new Trip();
            trip1.setId(1);
            trip1.setNomTrip("Rapel en Volcatenango");
            trip1.setDescripcion("Hacer rapel en los circuitos");
            trip1.setFecha(sdf.parse("10-05-2026"));
            trip1.setCosto(5.0);
            trip1.setDestacado(1);
            trip1.setImagen("trip01.png");

            Trip trip2 = new Trip();
            trip2.setId(2);
            trip2.setNomTrip("Deslizadero en El Picnic");
            trip2.setDescripcion("Deslízate en un tobogán");
            trip2.setFecha(sdf.parse("10-05-2026"));
            trip2.setCosto(5.0);
            trip2.setDestacado(0); 
            trip2.setImagen("trip02.png");

            Trip trip3 = new Trip();
            trip3.setId(3);
            trip3.setNomTrip("Comida y Flores");
            trip3.setDescripcion("Disfruta del jardín");
            trip3.setFecha(sdf.parse("10-05-2026"));
            trip3.setCosto(1.0);
            trip3.setDestacado(0);
            trip3.setImagen("trip03.png");

            lista.add(trip1);
            lista.add(trip2);
            lista.add(trip3);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Trip> buscarTodo() {
        return lista;
    }

    @Override
    public Trip buscarPorId(Integer idTrip) {
        for (Trip trip : lista) {
            if (trip.getId().equals(idTrip)) {
                return trip;
            }
        }
        return null; 
    }
}