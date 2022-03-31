package com.hours.kronos.controllers;

import com.hours.kronos.DTOs.UsuarioDto;
import com.hours.kronos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return UsuarioDto.parseModelInDto(usuarioService.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha()));
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
