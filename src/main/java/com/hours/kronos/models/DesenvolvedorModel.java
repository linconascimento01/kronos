package com.hours.kronos.models;

import com.hours.kronos.constantes.ConstantesBD;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "desenvolvedores", schema = "kronos_hours_db")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "squad_id")
    private Squad squad;

}
