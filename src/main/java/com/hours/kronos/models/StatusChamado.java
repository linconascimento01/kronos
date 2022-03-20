package com.hours.kronos.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "status_chamado")
public class StatusChamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id", nullable = false)
    private Integer id;

    @Column(name = "nome", length = 10)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "status")
    private Set<Chamado> chamados = new LinkedHashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "status_chamado_status_id")
    private List<Chamado> chamadoes = new ArrayList<>();

    public List<Chamado> getChamadoes() {
        return chamadoes;
    }

    public void setChamadoes(List<Chamado> chamadoes) {
        this.chamadoes = chamadoes;
    }
}