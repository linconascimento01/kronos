package com.hours.kronos.controllers;

import com.hours.kronos.DTOs.ClienteEmpresaDto;
import com.hours.kronos.exceptions.UsuarioNotFoundException;
import com.hours.kronos.models.ClienteEmpresaModel;
import com.hours.kronos.models.UsuarioModel;
import com.hours.kronos.services.ClienteEmpresaService;
import com.hours.kronos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        try {
            UsuarioModel usuarioModel = usuarioService.findById(clienteEmpresa.getUsuario().getUsuarioId());

            if(Objects.isNull(usuarioModel)) throw new UsuarioNotFoundException("Falha ao localiza usuario");

            clienteEmpresaModel.setUsuario(usuarioModel);
            clienteEmpresaModel = clienteEmpresaService.save(clienteEmpresaModel);

            if(Objects.isNull(clienteEmpresaModel) || Objects.isNull(clienteEmpresaModel.getId())){
                throw new Exception("falha ao salvar cliente empresa");
            }

            return ClienteEmpresaDto.parseModelInDto(clienteEmpresaModel);

        }catch (UsuarioNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "É necessário que tenham um usuario cadastrado", ex);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Não foi possivel cadastrar cliente empresa", ex);
        }
    }

    public ClienteEmpresaDto getClienteEmpresa(@RequestParam Integer id){
        return ClienteEmpresaDto.parseModelInDto(clienteEmpresaService.finedById(id));
    }
}
