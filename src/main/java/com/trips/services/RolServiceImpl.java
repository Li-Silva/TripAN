package com.trips.services;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.trips.models.Trip;


@Service
public class RolServiceImpl implements IRolService {

    private List<Trip> lista;

    public RolServiceImpl() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        lista = new LinkedList<>();

        try {
            Trip rol1 = new Trip();
            rol1.setId(1);
            rol1.setnomRol("gerente");
            rol1.setDescripcion("");
            rol1.setFecha(sdf.parse("10-05-2026"));

            

            Trip rol2 = new Trip();
            rol2.setId(2);
            rol2.setNomRol("");
            rol2.setDescripcion("");
            rol2.setFecha(sdf.parse("10-05-2026"));
           

            Trip rol3 = new Trip();
            rol3 .setId(3);
            rol3 .setNomRol("");
            rol3 .setDescripcion("");
            rol3 .setFecha(sdf.parse("10-05-2026"));


            lista.add(rol1);
            lista.add(rol2);
            lista.add(rol3);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Trip> buscarTodo() {
        return lista;
    }

    @Override
    public Trip buscarPorId(Integer idRol) {
        for (Trip rol : lista) {
            if (rol.getId().equals(idRol)) {
                return rol;
            }
        }
        return null; 
    }
}