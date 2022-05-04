package com.hours.kronos.controllers;

import com.hours.kronos.DTOs.TolkenDTO;
import com.hours.kronos.DTOs.UsuarioDto;
import com.hours.kronos.security.TolkenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TolkenService tolkenService;

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody UsuarioDto usuarioDto){
            UsernamePasswordAuthenticationToken dadosLogin = usuarioDto.converter();
        try {
            Authentication authentication = authenticationManager.authenticate(dadosLogin);
            String tolken = tolkenService.gerarTolken(authentication);
            System.out.println(tolken);
            return ResponseEntity.ok(new TolkenDTO(tolken, "Bearer"));
        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }

}
