package com.tomasmorinigo.ejercicio1.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomasmorinigo.ejercicio1.persistence.repository.ServicioRepository;
import com.tomasmorinigo.ejercicio1.persistence.entities.Servicio;

@Service
public class ServicioServiceImp implements ServicioService{

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    @Transactional(readOnly = true)
    public ArrayList<Servicio> getAllServicios() {
        return (ArrayList<Servicio>) servicioRepository.findAll();
    }

    @Override
    @Transactional
    public void saveServicio(Servicio servicio) {
        servicioRepository.save(servicio);
    }

    @Override
    @Transactional
    public void deleteServicioById(Integer id) {
        servicioRepository.deleteById(id);
    }
}
