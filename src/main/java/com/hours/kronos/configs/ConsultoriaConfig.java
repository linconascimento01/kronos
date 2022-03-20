package com.hours.kronos.configs;

import com.hours.kronos.repositorys.ConsultoriaRepository;
import com.hours.kronos.services.ConsultoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsultoriaConfig {

    @Autowired
    ConsultoriaRepository consultoriaRepository;

    public ConsultoriaService consultoriaService(){
        return new ConsultoriaService(consultoriaRepository);
    }
}
