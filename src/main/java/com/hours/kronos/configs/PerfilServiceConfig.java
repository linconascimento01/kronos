package com.hours.kronos.configs;

import com.hours.kronos.repositorys.PerfilRepository;
import com.hours.kronos.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PerfilServiceConfig {

    @Autowired
    PerfilRepository perfilRepository;

    @Bean
    public PerfilService perfilService(PerfilRepository perfilRepository){
        return new PerfilService(perfilRepository);
    }
}
