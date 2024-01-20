package com.tomasmorinigo.ejercicio1.persistence.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.tomasmorinigo.ejercicio1.persistence.entities.Servicio;

public interface ServicioRepository extends CrudRepository<Servicio, Integer>{
    public ArrayList<Servicio> findAll();
}
