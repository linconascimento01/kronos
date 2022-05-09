package com.hours.kronos.DTOs;

import com.hours.kronos.models.ConsultoriaModel;
import com.hours.kronos.models.UsuarioModel;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Builder
public class ConsultoriaDto implements Serializable {
    private final Integer consultoriaId;
    private final String razaoSocial;
    private final String nomeComercial;
    private final String cnpj;
    private final List<UsuarioDto> usuarios = new ArrayList<>();


    public static ConsultoriaDto parseModelInDto(ConsultoriaModel model){
        return ConsultoriaDto.builder()
                .consultoriaId(model.getConsultoriaId())
                .razaoSocial(model.getRazaoSocial())
                .nomeComercial(model.getNomeComercial())
                .cnpj(model.getCnpj())
               // .usuarios(UsuarioDto.parseModelsInDtos(model.getUsuarios()))
                .build();
    }

    public static List<ConsultoriaDto> parseModelsInDtos(List<ConsultoriaModel> models){
        List<ConsultoriaDto> listDTO = new ArrayList<>();
        models.forEach(m -> listDTO.add(ConsultoriaDto.parseModelInDto(m)));
        return listDTO;
    }

    public static ConsultoriaModel parseDtoInModel(ConsultoriaDto dto){
        return ConsultoriaModel.builder()
                .razaoSocial(dto.getRazaoSocial())
                .nomeComercial(dto.getNomeComercial())
                .cnpj(dto.getCnpj())
               // .usuarios(UsuarioDto.parseDtosInModels(dto.getUsuarios()))
                .build();
    }

    public void addUsuario(UsuarioDto usuario){
        this.usuarios.add(usuario);
    }
}
