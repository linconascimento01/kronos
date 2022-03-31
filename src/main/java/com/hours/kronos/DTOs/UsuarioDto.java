package com.hours.kronos.DTOs;

import com.hours.kronos.models.UsuarioModel;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Builder
public class UsuarioDto implements Serializable {
    private final Integer usuarioId;
    private final String nome;
    private final String email;
    private final String senha;
    private final Integer perfil;
    private final DesenvolvedorDto desenvolvedorDto;
    private final ConsultoriaDto consultoriaDto;


    public static UsuarioDto parseModelInDto(UsuarioModel model){
        DesenvolvedorDto desenvolvedorDto = null;
        if(Objects.nonNull(model.getDesenvolvedor())){
            desenvolvedorDto = DesenvolvedorDto.parseModelInDto(model.getDesenvolvedor());
        }

        return UsuarioDto.builder()
                .usuarioId(model.getUsuarioId())
                .nome(model.getNome())
                .email(model.getEmail())
                .senha(model.getSenha())
                .perfil(model.getPerfilModel())
                .desenvolvedorDto(desenvolvedorDto)
                //.consultoriaDto(model.getConsultoria())
                .build();
    }

    public static UsuarioModel parseDtoInModel(UsuarioDto dto){
        Integer desenvolvdorId = null;
        Integer consultoriaId = null;
        if(Objects.nonNull(dto.getDesenvolvedorDto())
                && Objects.nonNull(dto.getDesenvolvedorDto().getDesenvolvedorId())){
            desenvolvdorId = dto.getDesenvolvedorDto().getDesenvolvedorId();
        }

        if(Objects.nonNull(dto.getConsultoriaDto())
                && Objects.nonNull(dto.getConsultoriaDto().getConsultoriaId())){
            consultoriaId = dto.getDesenvolvedorDto().getDesenvolvedorId();
        }

        return UsuarioModel.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .perfilModel(dto.getPerfil())
                //.desenvolvedorId(desenvolvdorId)
                //.consultoriaId(consultoriaId)
                .build();
    }

//    public static List<UsuarioDto> parseModelsInDtos(List<UsuarioModel> model){
//        if(Objects.isNull(model)) return null;
//
//        List<UsuarioDto> usuarioDtos = new ArrayList<>();
//            for (UsuarioModel m: model) {
//                usuarioDtos.add(UsuarioDto.parseModelInDto(m));
//            }
//        return usuarioDtos;
//    }
//
//    public static List<UsuarioModel> parseDtosInModels(List<UsuarioDto> dtos){
//        if(Objects.isNull(dtos)) return null;
//
//        List<UsuarioModel> usuarioModels = new ArrayList<>();
//        for (UsuarioDto dto :dtos) {
//            usuarioModels.add(UsuarioDto.parseDtoInModel(dto));
//        }
//        return usuarioModels;
//    }
}
