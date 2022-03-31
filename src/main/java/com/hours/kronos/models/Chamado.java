package com.hours.kronos.models;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chamados")
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chamado_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sistema_id")
    @ToString.Exclude
    private Sistema sistema;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    @ToString.Exclude
    private StatusChamado status;

    @Column(name = "horas_atuacao")
    private Instant horasAtuacao;

    @Column(name = "data_abertura")
    private LocalDate dataAbertura;

    @Column(name = "data_atendimento")
    private LocalDate dataAtendimento;

    @Column(name = "data_encerramento")
    private LocalDate dataEncerramento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsavel_id")
    @ToString.Exclude
    private ClienteEmpresaModel responsavel;

    @Column(name = "relator_id", nullable = false)
    private Integer relatorId;

}