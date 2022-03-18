package com.hours.kronos.models;


import com.hours.kronos.constantes.ConstantesBD;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name = "usuario", schema = ConstantesBD.SCHEMA)
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToOne(mappedBy = "usuario")
    @JoinColumn(name = "desenvolvedor_id", referencedColumnName = "desenvolvedor_id")
    private DesenvolvedorModel desenvolvedor;
}
