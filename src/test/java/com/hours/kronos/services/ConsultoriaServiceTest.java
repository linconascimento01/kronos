package com.hours.kronos.services;

import com.hours.kronos.enums.PerfilEnum;
import com.hours.kronos.models.ConsultoriaModel;
import com.hours.kronos.models.UsuarioModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ConsultoriaServiceTest {

    @Autowired
    ConsultoriaService consultoriaService;

    @Autowired
    UsuarioService usuarioService;

    @Test
    public void saveTeste(){

        UsuarioModel usuarioModel = usuarioService.findById(1);

        List<UsuarioModel> usuarioModels= new ArrayList<>();
        usuarioModels.add(usuarioModel);

        if(usuarioModel.getPerfilModel().equals(PerfilEnum.DESENVOLVEDOR.getValue())){

        ConsultoriaModel consultoriaModel = ConsultoriaModel
                .builder()
                .cnpj("57793603000105")
                .razaoSocial("Consultoria A")
                .usuarios(usuarioModels)
                .build();

        consultoriaModel = consultoriaService.save(consultoriaModel);
        Assertions.assertNotNull(consultoriaModel.getConsultoriaId());
        }

    }

    @Test
    public void findByIdTest(){
        ConsultoriaModel consultoriaModel = consultoriaService.findById(1);

        Assertions.assertNotNull(consultoriaModel);
    }

    @Test
    public void findAll(){
        List<ConsultoriaModel> consultorias = consultoriaService.findAll();

        Assertions.assertTrue(consultorias.size() > 0);

    }


}
