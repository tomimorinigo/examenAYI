package com.example.demo.services;

import com.example.demo.persistence.entities.Proveedor;
import com.example.demo.persistence.repository.ProveedorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements ProveedorService{

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    @Transactional(readOnly = true)
    public ArrayList<Proveedor> getAllProveedores(){
        return(ArrayList<Proveedor>) proveedorRepository.findAll();
    }

    @Override
    @Transactional
    public void saveProveedor(Proveedor proveedor){
        proveedorRepository.save(proveedor);
    }

    @Override
    @Transactional
    public void editProveedor(Proveedor proveedor){
         proveedorRepository.save(proveedor);
    }

    @Override
    @Transactional
    public void deleteProveedor(Long id){
        proveedorRepository.deleteById(id);
    }


    @Transactional(readOnly = true)
    public Optional<Proveedor> getProveedorById(Long id){
        return proveedorRepository.findById(id);
    }
}
