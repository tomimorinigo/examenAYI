package com.tomasmorinigo.ejercicio1.services;

import java.util.ArrayList;

import com.tomasmorinigo.ejercicio1.persistence.entities.Servicio;

public interface ServicioService {
    public ArrayList<Servicio> getAllServicios();
    public void saveServicio(Servicio servicio);
    public void deleteServicioById(Integer id);
}
