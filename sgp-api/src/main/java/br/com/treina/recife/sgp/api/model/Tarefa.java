package br.com.treina.recife.sgp.api.model;

import java.time.LocalDate;

import br.com.treina.recife.sgp.api.enums.StatusPrioridadeTarefa;
import br.com.treina.recife.sgp.api.enums.StatusTarefa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TB_TAREFAS")

public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false)
    private LocalDate dataCriacao;

    private LocalDate dataConclusao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPrioridadeTarefa statusPrioridadeTarefa;

    private StatusTarefa statusTarefa;

    @ManyToOne
    @JoinColumn(nullable = false, name = "projeto_id")
    private Projeto projetoId;

    @ManyToOne
    @JoinColumn(nullable = false, name = "usuario_id")
    private Usuario usuarioId;

}
