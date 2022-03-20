package com.hours.kronos.services;

import com.hours.kronos.models.ConsultoriaModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ConsultoriaServiceTest {

    @Autowired
    ConsultoriaService consultoriaService;

    @Test
    public void saveTeste(){
        ConsultoriaModel consultoriaModel = ConsultoriaModel
                .builder()
                .cnpj("57793603000105")
                .razaoSocial("Consultoria A")
                .build();

        consultoriaModel = consultoriaService.save(consultoriaModel);

        Assertions.assertNotNull(consultoriaModel.getConsultoriaId());
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
