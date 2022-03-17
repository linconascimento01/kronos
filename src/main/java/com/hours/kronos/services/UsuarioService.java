package com.hours.kronos.services;

import com.hours.kronos.models.UsuarioModel;
import com.hours.kronos.repositorys.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioModel save(UsuarioModel usuarioModel){
        if(usuarioModel.getEmail() != null && usuarioModel.getSenha() != null){
           return usuarioRepository.save(usuarioModel);
        }
        return null;
    }

    public UsuarioModel findById(Integer idUsuario){
        Optional<UsuarioModel> usuarioModel = usuarioRepository.findById(idUsuario);
        return usuarioModel.orElse(null);
    }

    public List<UsuarioModel> findAll(){
        List<UsuarioModel> usuarioModels = new ArrayList<>();
        usuarioRepository.findAll().forEach(usuarioModels::add);
        return usuarioModels;
    }

    public void delete(Integer idUsuario){
        usuarioRepository.deleteById(idUsuario);
    }

    public UsuarioModel findByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }
}
