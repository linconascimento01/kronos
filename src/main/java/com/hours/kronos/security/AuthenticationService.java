package com.hours.kronos.security;

import com.hours.kronos.models.UsuarioModel;
import com.hours.kronos.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioModel> usuarioModel = usuarioRepository.findByEmail(username);
        if(usuarioModel.isPresent()){
            return usuarioModel.get();
        }
        throw new UsernameNotFoundException("Dados invalidos");
    }
}
