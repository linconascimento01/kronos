package com.hours.kronos.models;

import com.hours.kronos.constantes.ConstantesBD;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "perfil", schema = "kronos_hours_db")
public class PerfilModel {

    @Id
    @Column(name = "perfil_id")
    private Integer idPerfil;

    @Column(name = "nome")
    private String nome;
}
