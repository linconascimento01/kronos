package com.hours.kronos.controllers;

import com.hours.kronos.DTOs.UsuarioDto;
import com.hours.kronos.exceptions.UsuarioNotFoundException;
import com.hours.kronos.models.UsuarioModel;
import com.hours.kronos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

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
        usuarioService.save(UsuarioDto.parseDtoInModel(usuario));
        return usuario;
    }

    @PutMapping("/usuario")
    private UsuarioDto update(@RequestBody UsuarioDto usuario) {
        usuarioService.save(UsuarioDto.parseDtoInModel(usuario));
        return usuario;
    }
}
