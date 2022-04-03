package com.hours.kronos.DTOs;

import com.hours.kronos.models.ClienteEmpresaModel;
import com.hours.kronos.models.ConsultoriaModel;
import com.hours.kronos.models.UsuarioModel;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Builder
public class ClienteEmpresaDto implements Serializable {
    private final Integer id;
    private final String razaoSocial;
    private final String nomeComercial;
    private final String cnpj;
    private final UsuarioDto usuario;
    private final ConsultoriaDto consultoria;

    public static ClienteEmpresaDto parseModelInDto(ClienteEmpresaModel model){
        ConsultoriaDto consultoriaDto =
                (Objects.nonNull(model.getConsultoria()) &&
                        Objects.nonNull(model.getConsultoria().getConsultoriaId()))
                        ? ConsultoriaDto.parseModelInDto(model.getConsultoria())
                        : null;

        return ClienteEmpresaDto.builder()
                .id(model.getId())
                .razaoSocial(model.getRazaoSocial())
                .cnpj(model.getCnpj())
                .usuario(UsuarioDto.parseModelInDto(model.getUsuario()))
                .consultoria(consultoriaDto)
                .build();
    }

    public static ClienteEmpresaModel parseDtoInModel(ClienteEmpresaDto dto){
        ConsultoriaModel consultoriaModel =
                (Objects.nonNull(dto.getConsultoria()) && Objects.nonNull(dto.getConsultoria().getConsultoriaId())
                        ? ConsultoriaDto.parseDtoInModel(dto.getConsultoria())
                        : null);

        UsuarioModel usuarioModel =
                (Objects.nonNull(dto.getUsuario())
                        ? UsuarioDto.parseDtoInModel(dto.getUsuario())
                        : null);

        return ClienteEmpresaModel.builder()
                .razaoSocial(dto.getRazaoSocial())
                .nomeComercial(dto.getNomeComercial())
                .cnpj(dto.getCnpj())
                .usuario(usuarioModel)
                .consultoria(consultoriaModel)
                .build();
    }
}
