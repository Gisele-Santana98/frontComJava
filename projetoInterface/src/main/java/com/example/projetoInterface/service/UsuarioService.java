package com.example.projetoInterface.service;

import com.example.projetoInterface.model.Usuario;
import com.example.projetoInterface.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void salvar(Usuario usuario){
        usuarioRepository.save(usuario);
    }
    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }
}
