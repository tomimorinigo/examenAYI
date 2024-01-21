package com.example.demo.services;

import com.example.demo.persistence.entities.Usuario;
import com.example.demo.persistence.repository.UsuarioRepository;
import jakarta.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public boolean login(String nombre, String password){
       Usuario usuario = usuarioRepository.findByNombre(nombre);

       if (usuario != null){
           return usuario.getPasswordUsuario().equals(password);
       } else {
           return false;
       }
    }
}
