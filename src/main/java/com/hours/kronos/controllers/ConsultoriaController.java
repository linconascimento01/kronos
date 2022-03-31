package com.hours.kronos.controllers;

import com.hours.kronos.DTOs.ConsultoriaDto;
import com.hours.kronos.DTOs.UsuarioDto;
import com.hours.kronos.exceptions.UsuarioNotFoundException;
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

            if(Objects.isNull(consultoriaModel.getConsultoriaId())) throw new Exception();

            if(Objects.nonNull(consultoria.getUsuarios())
                    && Objects.nonNull(consultoria.getUsuarios().get(0))){

                UsuarioModel usuarioModel = usuarioService.findById(consultoria.getUsuarios().get(0).getUsuarioId());

                if(Objects.nonNull(usuarioModel)){
                    usuarioModel.setConsultoria(consultoriaModel);
                    usuarioService.update(usuarioModel);
                    return ConsultoriaDto.parseModelInDto(consultoriaModel);
                }
            }
            throw new UsuarioNotFoundException("Usuario não cadastrado");
        }catch (UsuarioNotFoundException ex){
            //deletar a consultoria que foi salva
            consultoriaService.deleteById(consultoriaModel.getConsultoriaId());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "É necessário que tenham um usuario cadastrado", ex);
        }
        catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Error", ex);
        }
    }

    @GetMapping("/consultoria/{id}")
    public ConsultoriaDto getConsultoria(@RequestParam Integer id){
        return ConsultoriaDto.parseModelInDto(consultoriaService.findById(id));
    }

}
