package com.hours.kronos.configs;

import com.hours.kronos.repositorys.ConsultoriaRepository;
import com.hours.kronos.repositorys.UsuarioRepository;
import com.hours.kronos.services.ConsultoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsultoriaConfig {

    @Autowired
    ConsultoriaRepository consultoriaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public ConsultoriaService consultoriaService(){

        return new ConsultoriaService(consultoriaRepository, usuarioRepository);
    }
}
