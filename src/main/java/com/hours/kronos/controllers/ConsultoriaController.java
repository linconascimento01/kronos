package com.hours.kronos.controllers;

import com.hours.kronos.DTOs.ConsultoriaDto;
import com.hours.kronos.DTOs.UsuarioDto;
import com.hours.kronos.models.ConsultoriaModel;
import com.hours.kronos.models.UsuarioModel;
import com.hours.kronos.services.ConsultoriaService;
import com.hours.kronos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("api")
public class ConsultoriaController {

    @Autowired
    ConsultoriaService consultoriaService;

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/consultoria/cadastrar")
    public ConsultoriaDto cadastrar(@RequestBody ConsultoriaDto consultoria){
        ConsultoriaModel consultoriaModel = ConsultoriaDto.parseDtoInModel(consultoria);
        try {
            consultoriaModel = consultoriaService.save(consultoriaModel);
            if(Objects.nonNull(consultoriaModel.getConsultoriaId())
                    && Objects.nonNull(consultoria.getUsuarios())
                    && Objects.nonNull(consultoria.getUsuarios().get(0))){

                UsuarioModel usuarioModel = usuarioService.findById(consultoria.getUsuarios().get(0).getUsuarioId());
                usuarioModel.setConsultoria(consultoriaModel);
                usuarioService.update(usuarioModel);
                return ConsultoriaDto.parseModelInDto(consultoriaModel);
            }
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Error", ex);
        }
        return null;
    }

    @GetMapping("/consultoria/{id}")
    public ConsultoriaDto getConsultoria(@RequestParam Integer id){
        return ConsultoriaDto.parseModelInDto(consultoriaService.findById(id));
    }

}
