package com.hours.kronos.models;

import com.hours.kronos.constantes.ConstantesBD;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "consultoria", schema = "kronos_hours_db")
public class ConsultoriaModel {

    @Id
    @Column(name = "consultoria_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer consultoriaId;

    @Column(name = "razao_social")
    private String razaoSocial;

    @Column(name = "nome_comercial")
    private String nomeComercial;

    @Column(name = "cnpj")
    private String cnpj;

    @OneToMany(mappedBy = "consultoria")
    private List<UsuarioModel> usuarios;

    @OneToMany(mappedBy = "consultoria")
    private List<ClienteEmpresaModel> clienteEmpresas;

}
