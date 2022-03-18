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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "desenvolvedores", schema = ConstantesBD.SCHEMA)
public class DesenvolvedorModel {

    @Id
    @Column(name="desenvolvedor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer desenvolvedorId;

    @Column(name = "senioridade")
    private String senioridade;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private UsuarioModel usuario;
}
