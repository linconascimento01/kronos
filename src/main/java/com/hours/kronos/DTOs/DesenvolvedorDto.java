package com.hours.kronos.DTOs;

import com.hours.kronos.models.DesenvolvedorModel;
import com.hours.kronos.models.UsuarioModel;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Builder
public class DesenvolvedorDto implements Serializable {
    private final Integer desenvolvedorId;
    private final String senioridade;
    private final UsuarioDto usuario;


    public static DesenvolvedorDto parseModelInDto(DesenvolvedorModel model){
        UsuarioDto usuarioDto = (!Objects.isNull(model.getUsuario())
                ? UsuarioDto.parseModelInDto(model.getUsuario())
                : null);

        return DesenvolvedorDto.builder()
                .desenvolvedorId(model.getDesenvolvedorId())
                .senioridade(model.getSenioridade())
                .usuario(usuarioDto)
                .build();
    }

    public static DesenvolvedorModel parseDtoInModel(DesenvolvedorDto dto){
        UsuarioModel usuarioModel = (Objects.nonNull(dto.getUsuario())
                ? UsuarioDto.parseDtoInModel(dto.getUsuario())
                : null);
        return DesenvolvedorModel.builder().senioridade(dto.getSenioridade()).usuario(usuarioModel).build();
    }

    public static DesenvolvedorModel parseDtoInModel(DesenvolvedorDto dto, UsuarioModel model){
        return DesenvolvedorModel.builder().senioridade(dto.getSenioridade()).usuario(model).build();
    }
}
