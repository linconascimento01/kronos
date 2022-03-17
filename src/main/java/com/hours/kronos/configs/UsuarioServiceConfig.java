package com.hours.kronos.configs;

import com.hours.kronos.repositorys.UsuarioRepository;
import com.hours.kronos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioServiceConfig {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Bean
    public UsuarioService usuarioService(){
        return new UsuarioService(usuarioRepository);
    }
}
