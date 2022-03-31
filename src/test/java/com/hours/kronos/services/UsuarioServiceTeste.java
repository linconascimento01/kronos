package com.hours.kronos.services;

import com.hours.kronos.models.UsuarioModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsuarioServiceTeste {

    @Autowired
    UsuarioService usuarioService;

    @Test
    public void testUsuarioService(){

        //cria um usuario
        UsuarioModel usuarioModel = UsuarioModel
                .builder()
                .nome("João")
                .email("João@kronos.com.br")
                .senha("123456")
                .perfilModel(1).build();
        //salva o usuario no banco de dados
       // UsuarioModel retornoUsuario = usuarioService.save(usuarioModel);

//        //verifica se o usuario foi realmente salvo
//        Assertions.assertNotNull(retornoUsuario.getUsuarioId());
//        Assertions.assertEquals(usuarioModel.getEmail(), retornoUsuario.getEmail());

        // faz a busca do usuario por email
        UsuarioModel usuarioModel1 = usuarioService.findByEmailAndSenha("João123@teste123", "abc123");
        Assertions.assertEquals("João", usuarioModel.getNome());

        // apaga o usuario do banco de dados
        usuarioService.delete(usuarioModel1.getUsuarioId());
        usuarioModel = usuarioService.findById(usuarioModel.getUsuarioId());

        //verifica se o usuario realmente foi deletado
        Assertions.assertNull(usuarioModel);
    }



}
