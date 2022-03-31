package com.hours.kronos;

import com.hours.kronos.DTOs.ClienteEmpresaDto;
import com.hours.kronos.DTOs.ConsultoriaDto;
import com.hours.kronos.DTOs.DesenvolvedorDto;
import com.hours.kronos.DTOs.UsuarioDto;
import com.hours.kronos.enums.PerfilEnum;
import com.hours.kronos.models.ClienteEmpresaModel;
import com.hours.kronos.models.ConsultoriaModel;
import com.hours.kronos.models.DesenvolvedorModel;
import com.hours.kronos.models.UsuarioModel;
import com.hours.kronos.services.ClienteEmpresaService;
import com.hours.kronos.services.ConsultoriaService;
import com.hours.kronos.services.DesenvolvedorService;
import com.hours.kronos.services.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class FluxoCadastrosTest {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ConsultoriaService consultoriaService;

    @Autowired
    DesenvolvedorService desenvolvedorService;

    @Autowired
    ClienteEmpresaService clienteEmpresaService;

    @Test
    public void cadastroConsultoriaTest(){

        //para realizar o cadastro de uma consultoria é necessario que haja um usuario com o perfil de adiministrador
        UsuarioDto usuarioDto = UsuarioDto.builder()
                .nome("Gilmar da silva")
                .email("gilmar@kronoshours.com")
                .senha("1234567")
                .perfil(PerfilEnum.ADMINISTRADOR.getValue())
                .build();
        //Salvo o usuario do tipo adiministrador
        UsuarioModel model = usuarioService.save(UsuarioDto.parseDtoInModel(usuarioDto));

        //cria um dto com uma nova consultoria
        ConsultoriaDto consultoriaDto = ConsultoriaDto.builder()
                .nomeComercial("Consultoria A2")
                .razaoSocial("consultoria Ltda")
                .cnpj("46313514000589")
                .build();

        //adiciona o usuario a nova consultoria
        consultoriaDto.addUsuario(UsuarioDto.parseModelInDto(model));

        //salva a consultoria
        ConsultoriaModel consultoriaModel = consultoriaService.save(ConsultoriaDto.parseDtoInModel(consultoriaDto));

        //adiciona a consultoria ao usuario
        model.setConsultoria(consultoriaModel);
        //model.setConsultoriaId(consultoriaModel.getConsultoriaId());

        //atualiza o registro
        usuarioService.save(model);

    }

    @Test
    public void cadastrarDesenvolvedorTest(){
        //é necessario que o adiministrador de uma consultoria esteja logado para fazer o cadastro dos desenvolvedores
        ConsultoriaModel consultoriaModel = consultoriaService.findById(2);

        //para realizar o cadastro de um desenvolvedor é necessario que haja um usuario com o perfil de desenvolvedor
        UsuarioDto usuarioDto = UsuarioDto.builder()
                .nome("Manoel Pereira")
                .email("manoel12@kronoshours.com")
                .senha("895951")
                .perfil(PerfilEnum.DESENVOLVEDOR.getValue())
                .build();
        UsuarioModel model = UsuarioDto.parseDtoInModel(usuarioDto);
        model.setConsultoria(consultoriaModel);
        //Salvo o usuario do tipo adiministrador
        model = usuarioService.save(model);

        DesenvolvedorDto dto = DesenvolvedorDto.builder()
                .senioridade("Pleno")
                .usuario(UsuarioDto.parseModelInDto(model))
                .build();

        desenvolvedorService.save(DesenvolvedorDto.parseDtoInModel(dto, model));

    }

    @Test
    public void cadastroClienteEmpresa(){
        UsuarioDto usuarioDto = UsuarioDto.builder()
                .nome("Lorena da silva")
                .email("lorena@kronoshours.com")
                .senha("1234567")
                .perfil(PerfilEnum.CLIENTE_EMPRESA.getValue())
                .build();
        UsuarioModel usuarioModel = usuarioService.save(UsuarioDto.parseDtoInModel(usuarioDto));

        ClienteEmpresaDto clienteEmpresaDto = ClienteEmpresaDto
                .builder()
                .razaoSocial("Cliente empresa A")
                .nomeComercial("cliente epresa A ltda")
                .cnpj("46313514000589")
                .build();
        ClienteEmpresaModel clienteEmpresaModel = ClienteEmpresaDto.parseDtoInModel(clienteEmpresaDto);

        ConsultoriaModel consultoriaModel = consultoriaService.findById(2);

        clienteEmpresaModel.setConsultoria(consultoriaModel);

        clienteEmpresaModel = clienteEmpresaService.save(clienteEmpresaModel);

        usuarioModel.setClienteEmpresa(clienteEmpresaModel);
        usuarioService.save(usuarioModel);

    }
}
