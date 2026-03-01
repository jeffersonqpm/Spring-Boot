package br.com.treina.recife.sgp.api.model;

import java.time.LocalDate;

import br.com.treina.recife.sgp.api.enums.StatusProjeto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // cria get sets
@NoArgsConstructor // CRIA O CONSTRUTUOR SEM ARGUMENTOS
@AllArgsConstructor // CRIA O CONTRUTOR COM OS ARGUMENTOS
@Entity(name = "TB_PROJETOS") // NOME DA TABELA NO BD

public class Projeto {

    @Id // chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // VARCHAR(50) NOT NULL
    @Column(nullable = false, length = 100)
    private String nome;

    // VARCHAR(50) NOT NULL
    // @Column(nullable = false)
    @Column(columnDefinition = "TEXT")
    private String descricao;

    // DATETIME NOT NULL
    @Column(nullable = false)
    private LocalDate dataInicio;

    private LocalDate dataFinal;

    // mapear um campo de enumeração (enum)
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusProjeto status;

    @ManyToOne // relação com usuario
    // @OneToOne so pode ser um usuario para cada projeto
    @JoinColumn(nullable = false, name="usuario_resp_id")
    private Usuario responsavel;



}
