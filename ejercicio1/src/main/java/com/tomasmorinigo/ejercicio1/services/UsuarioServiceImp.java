package com.tomasmorinigo.ejercicio1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomasmorinigo.ejercicio1.persistence.entities.Usuario;
import com.tomasmorinigo.ejercicio1.persistence.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImp implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public boolean login(String nombre, String contrasenia) {
        Usuario usuario = usuarioRepository.findByNombre(nombre);
        
        if (usuario != null) {
            return usuario.getContrasenia().equals(contrasenia);
        } else {
            return false;
        }
    }
}
