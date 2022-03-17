package com.hours.kronos.models;

import com.hours.kronos.constantes.ConstantesBD;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "perfil", schema = ConstantesBD.SCHEMA)
public class PerfilModel {

    @Id
    @Column(name = "perfil_id")
    private Integer idPerfil;

    @Column(name = "nome")
    private String nome;
}
