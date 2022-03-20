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
@Table(name = "sistemas")
public class Sistema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sistema_id", nullable = false)
    private Integer id;

    @Column(name = "nome", length = 150)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_empresa_id")
    private ClienteEmpresaModel clienteEmpresa;

    @Getter
    @Setter
    @OneToMany(mappedBy = "sistema")
    private Set<Chamado> chamados = new LinkedHashSet<>();

}