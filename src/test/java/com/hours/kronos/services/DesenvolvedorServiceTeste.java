package com.hours.kronos.services;

import com.hours.kronos.PerfilEnum;
import com.hours.kronos.models.DesenvolvedorModel;
import com.hours.kronos.models.UsuarioModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DesenvolvedorServiceTeste {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    DesenvolvedorService desenvolvedorService;

    @Test
    public void testDesenvolvedorService(){
        UsuarioModel usuarioModel = usuarioService.findById(3);
        if(usuarioModel.getPerfilModel().equals(PerfilEnum.DESENVOLVEDOR.getValue())){
            desenvolvedorService.save(DesenvolvedorModel
                    .builder()
                    .senioridade("Junior")
                    .usuario(usuarioModel)
                    .build());
            DesenvolvedorModel desenvolvedorModel = desenvolvedorService.findByUsuarioId(usuarioModel);
            usuarioModel.setDesenvolvedor(desenvolvedorModel);
            usuarioService.save(usuarioModel);

            Assertions.assertNotNull(desenvolvedorModel);

            //desenvolvedorService.deleteById(desenvolvedorModel.getDesenvolvedorId());
        }
    }

}

