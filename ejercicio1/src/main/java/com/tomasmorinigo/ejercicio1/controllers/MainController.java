package com.tomasmorinigo.ejercicio1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tomasmorinigo.ejercicio1.persistence.entities.Producto;
import com.tomasmorinigo.ejercicio1.persistence.entities.Servicio;
import com.tomasmorinigo.ejercicio1.persistence.entities.Usuario;
import com.tomasmorinigo.ejercicio1.services.ProductoService;
import com.tomasmorinigo.ejercicio1.services.ServicioService;
import com.tomasmorinigo.ejercicio1.services.UsuarioService;

@Controller
public class MainController {
    @Value("${tituloProducto}")
    private String tituloProducto;

    @Value("${tituloServicio}")
    private String tituloServicio;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ServicioService servicioService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "index";
    }
    
    @PostMapping("/login")
    public String login(Usuario usuario) {
        boolean response = usuarioService.login(usuario.getNombre(), usuario.getContrasenia());
        if (response) {
            return "redirect:/home";
        }
        return "redirect:/";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("productos", productoService.getAllProductos());
        model.addAttribute("servicios", servicioService.getAllServicios());
        model.addAttribute("tituloProducto", tituloProducto);
        model.addAttribute("tituloServicio", tituloServicio);
        return "home";
    }

    @GetMapping("/newItem/producto")
    public String newItemProducto(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("servicio", null);
        model.addAttribute("title", "Ingresar un nuevo producto");
        return "newItem";
    }

    @GetMapping("/newItem/servicio")
    public String newItemServicio(Model model) {
        model.addAttribute("servicio", new Servicio());
        model.addAttribute("producto", null);
        model.addAttribute("title", "Ingresar un nuevo servicio");
        return "newItem";
    }

    @PostMapping("/save/producto")
    public String saveProducto(Producto producto) {
        productoService.saveProducto(producto);
        return "redirect:/home";
    }

    @PostMapping("/save/servicio")
    public String saveServicio(Servicio servicio) {
        servicioService.saveServicio(servicio);
        return "redirect:/home";
    }

    @GetMapping("/eliminar/producto/{id}")
    public String deleteProducto(@PathVariable Integer id) {
        productoService.deleteProductoById(id);
        return "redirect:/home";
    }

    @GetMapping("/eliminar/servicio/{id}")
    public String deleteServicio(@PathVariable Integer id) {
        servicioService.deleteServicioById(id);
        return "redirect:/home";
    }
}
