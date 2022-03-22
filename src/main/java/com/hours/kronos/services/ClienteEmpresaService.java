package com.hours.kronos.services;

import com.hours.kronos.models.ClienteEmpresaModel;
import com.hours.kronos.models.ConsultoriaModel;
import com.hours.kronos.repositorys.ClienteEmpresaRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ClienteEmpresaService {

    @Autowired
    ClienteEmpresaRepository clienteEmpresaRepository;

    public ClienteEmpresaModel save(ClienteEmpresaModel clienteEmpresaModel){
        return clienteEmpresaRepository.save(clienteEmpresaModel);
    }

    public ClienteEmpresaModel finedById(Integer id){
        return clienteEmpresaRepository.findById(id).orElse(null);
    }

    public List<ClienteEmpresaModel> findAll(){
        return new ArrayList<>(clienteEmpresaRepository.findAll());
    }
}
