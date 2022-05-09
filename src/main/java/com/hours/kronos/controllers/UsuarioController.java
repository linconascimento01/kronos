package com.hours.kronos.controllers;

import com.hours.kronos.DTOs.UsuarioDto;
import com.hours.kronos.models.UsuarioModel;
import com.hours.kronos.services.UsuarioService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("api")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuario/{idUsuario}")
    private UsuarioDto getUsuario(@PathVariable Integer idUsuario) {
        return UsuarioDto.parseModelInDto(usuarioService.findById(idUsuario));
    }

    @GetMapping("/usuario")
    private List<UsuarioDto> getAllUsuario() {
        return UsuarioDto.parseModelsInDtos(usuarioService.findAll());
    }

    @PostMapping("/logar")
    private UsuarioDto getUsuario(@RequestBody UsuarioDto usuario) {
        try {
            UsuarioModel usuarioModel = usuarioService.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
            return UsuarioDto.parseModelInDto(usuarioModel);
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "usuario não cadastrado", ex);
        }
    }

    @PostMapping("/usuario")
    private UsuarioDto save(@RequestBody UsuarioDto usuario) {
        System.out.println("** PERFIL USUARIO = "+usuario.getPerfil());
        UsuarioModel usuarioModel = UsuarioDto.parseDtoInModel(usuario);
        usuarioModel = usuarioService.save(usuarioModel);
        return UsuarioDto.parseModelInDto(usuarioModel);
    }

    @PutMapping("/usuario")
    private UsuarioDto update(@RequestBody UsuarioDto usuario) {
        usuarioService.save(UsuarioDto.parseDtoInModel(usuario));
        return usuario;
    }
}
