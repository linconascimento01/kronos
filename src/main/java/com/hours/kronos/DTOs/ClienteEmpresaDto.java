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
        return ClienteEmpresaDto.builder()
                .id(model.getId())
                .razaoSocial(model.getRazaoSocial())
                .cnpj(model.getCnpj())
                .usuario(UsuarioDto.parseModelInDto(model.getUsuario()))
                .consultoria(ConsultoriaDto.parseModelInDto(model.getConsultoria()))
                .build();
    }

    public static ClienteEmpresaModel parseDtoInModel(ClienteEmpresaDto dto){
        ConsultoriaModel consultoriaModel =
                (Objects.nonNull(dto.getConsultoria())
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
