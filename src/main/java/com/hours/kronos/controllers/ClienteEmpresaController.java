package com.hours.kronos.controllers;

import com.hours.kronos.DTOs.ClienteEmpresaDto;
import com.hours.kronos.models.ClienteEmpresaModel;
import com.hours.kronos.models.UsuarioModel;
import com.hours.kronos.services.ClienteEmpresaService;
import com.hours.kronos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("api")
public class ClienteEmpresaController {

    @Autowired
    ClienteEmpresaService clienteEmpresaService;

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("cliente-empresa/cadastrar")
    public ClienteEmpresaDto cadastrar(@RequestBody ClienteEmpresaDto clienteEmpresa){
        ClienteEmpresaModel clienteEmpresaModel = ClienteEmpresaDto.parseDtoInModel(clienteEmpresa);
        UsuarioModel usuarioModel = usuarioService.findById(clienteEmpresa.getUsuario().getUsuarioId());
        clienteEmpresaModel.setUsuario(usuarioModel);
        clienteEmpresaModel = clienteEmpresaService.save(clienteEmpresaModel);
        if(Objects.nonNull(clienteEmpresaModel) && Objects.nonNull(clienteEmpresaModel.getId())){
            return ClienteEmpresaDto.parseModelInDto(clienteEmpresaModel);
        }
        return null;
    }

    public ClienteEmpresaDto getClienteEmpresa(@RequestParam Integer id){
        return ClienteEmpresaDto.parseModelInDto(clienteEmpresaService.finedById(id));
    }
}
