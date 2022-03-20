package com.hours.kronos.models;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "squads")
public class Squad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "squad_id", nullable = false)
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_empresa_id")
    private ClienteEmpresaModel clienteEmpresa;

    @OneToMany(mappedBy = "squad")
    private Set<DesenvolvedorModel> desenvolvedores = new LinkedHashSet<>();


}