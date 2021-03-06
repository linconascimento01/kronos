package com.hours.kronos.models;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente_empresas")
public class ClienteEmpresaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_empresa_id", nullable = false)
    private Integer id;

    @Column(name = "razao_social")
    private String razaoSocial;

    @Column(name = "nome_comercial")
    private String nomeComercial;

    @Column(name = "cnpj", length = 14)
    private String cnpj;

    @Column(name = "flag_consultoria")
    private Boolean flagConsultoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consultoria_id", referencedColumnName = "consultoria_id")
    private ConsultoriaModel consultoria;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private UsuarioModel usuario;

}