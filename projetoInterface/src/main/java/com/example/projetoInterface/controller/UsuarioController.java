package com.example.projetoInterface.controller;
import com.example.projetoInterface.model.Usuario;
import com.example.projetoInterface.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioController {
    UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping("/cadastro")
    public String exibirFormulario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }
    @PostMapping("/redirect")
    public String cadastroUsuario(Usuario usuario){
        usuarioService.salvar(usuario);
        return "redirect:/cadastro";
    }
    @GetMapping("/lista")
    public String listarUsuarios(Model model){
        List<Usuario> usuarios = usuarioService.listarTodos();
        model.addAttribute("usuarios", usuarios);
        return "lista";
    }
}