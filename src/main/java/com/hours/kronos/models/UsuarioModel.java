package com.hours.kronos.models;


import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario", schema = "kronos_hours_db")
public class UsuarioModel {

    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer usuarioId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "perfil_id")
    private Integer perfilModel;

    @JoinColumn(name = "desenvolvedor_id", referencedColumnName = "desenvolvedor_id")
    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY)
    private DesenvolvedorModel desenvolvedor;

    @JoinColumn(name = "consultoria_id", referencedColumnName = "consultoria_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ConsultoriaModel consultoria;

    @JoinColumn(name = "cliente_empresa_id", referencedColumnName = "cliente_empresa_id")
    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY)
    private ClienteEmpresaModel clienteEmpresa;

}
