package com.hours.kronos.configs;

import com.hours.kronos.repositorys.DesenvolvedorRepository;
import com.hours.kronos.repositorys.UsuarioRepository;
import com.hours.kronos.services.DesenvolvedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DesenvolvedorConfig {

    @Autowired
    DesenvolvedorRepository desenvolvedorRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public DesenvolvedorService desenvolvedorService(){
        return new DesenvolvedorService(desenvolvedorRepository, usuarioRepository);
    }
}
