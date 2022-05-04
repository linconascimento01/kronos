package com.hours.kronos.services;

import com.hours.kronos.models.UsuarioModel;
import com.hours.kronos.repositorys.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public UsuarioModel update(UsuarioModel usuarioModel){
       return usuarioRepository.save(usuarioModel);
    }

    public UsuarioModel findById(Long idUsuario){
        Optional<UsuarioModel> usuarioModel = usuarioRepository.findById(idUsuario);
        return usuarioModel.orElse(null);
    }

    public List<UsuarioModel> findAll(){
        return new ArrayList<>(usuarioRepository.findAll());
    }

    public void delete(Long idUsuario){

        usuarioRepository.deleteById(idUsuario);
    }

    public UsuarioModel findByEmailAndSenha(String email, String senha){

        return usuarioRepository.findByEmailAndSenha(email, senha);
    }


}
