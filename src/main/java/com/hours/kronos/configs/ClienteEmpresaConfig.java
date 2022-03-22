package com.hours.kronos.configs;

import com.hours.kronos.repositorys.ClienteEmpresaRepository;
import com.hours.kronos.services.ClienteEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class ClienteEmpresaConfig {

    @Autowired
    ClienteEmpresaRepository clienteEmpresaRepository;

    @Bean
    public ClienteEmpresaService consultoriaService(){
        return new ClienteEmpresaService(clienteEmpresaRepository);
    }

}
