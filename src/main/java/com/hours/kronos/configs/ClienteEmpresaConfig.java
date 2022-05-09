package com.hours.kronos.configs;

import com.hours.kronos.repositorys.ClienteEmpresaRepository;
import com.hours.kronos.services.ClienteEmpresaService;
import com.hours.kronos.services.ConsultoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteEmpresaConfig {

    @Autowired
    ClienteEmpresaRepository clienteEmpresaRepository;

    @Autowired
    ConsultoriaService consultoriaService;

    @Bean
    public ClienteEmpresaService clienteEmpresaService(){
        return new ClienteEmpresaService(clienteEmpresaRepository, consultoriaService);
    }

}
