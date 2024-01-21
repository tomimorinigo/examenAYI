package com.example.demo.controllers;


import com.example.demo.persistence.entities.Proveedor;
import com.example.demo.persistence.entities.Usuario;
import com.example.demo.services.ProveedorService;
import com.example.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@Controller
public class MainController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("Usuario", new Usuario());
        return "index";
    }

    @PostMapping("/login")
    public String login(Usuario usuario) {
        boolean response = usuarioService.login(usuario.getNombre(), usuario.getPasswordUsuario());
        if(response) {
            return "redirect:/home";
        }
        return "redirect:/";
    }

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("proveedor", proveedorService.getAllProveedores());
        return "home";
    }

    @GetMapping("/insertar")
    public String insertar(Model model){
        model.addAttribute("proveedor", new Proveedor());
        return "insertar";
    }

    @PostMapping("/insertar")
    public String saveProveedor(Proveedor proveedor){
        proveedorService.saveProveedor(proveedor);
        return "redirect:/home";
    }


    @GetMapping("/eliminar/proveedor/{id}")
    public String deleteProveedor(@PathVariable Long id){
        proveedorService.deleteProveedor(id);
        return "redirect:/home";
    }

    @GetMapping("/editar/proveedor/{id}")
    public String editProveedor(@PathVariable Long id, Model model){
        Optional<Proveedor> proveedorOptional = proveedorService.getProveedorById(id);
        if(proveedorOptional.isPresent()){
            Proveedor proveedor = proveedorOptional.get();
            model.addAttribute("proveedor", proveedor);
        } else{
            return "redirect:/error";
        }
        return "editar";
    }

    @PostMapping("/guardarCambios")
    public String guardarCambios(@ModelAttribute("proveedor") Proveedor proveedor){
        proveedorService.editProveedor(proveedor);
        return "redirect:/home";
    }
}
