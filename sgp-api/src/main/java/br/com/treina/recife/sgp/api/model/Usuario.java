package br.com.treina.recife.sgp.api.model;

import jakarta.persistence.Entity;

import java.time.LocalDate;

//import jakarta.annotation.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data// cria get sets 
@NoArgsConstructor // CRIA O CONSTRUTUOR SEM ARGUMENTOS
@AllArgsConstructor // CRIA O CONTRUTOR COM OS ARGUMENTOS
@Entity(name = "TB_USUARIOS") // NOME DA TABELA NO BD

public class Usuario {
    @Id // chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // VARCHAR(50) NOT NULL
    @Column(nullable = false, length = 50)
    private String nome;

    // varchar(11) NOT NULL UNIQUE
    @Column(nullable = false, length = 11, unique = true)
    private String cpf;
    // VARCHAR(255) NOT NULL UNIQUE
    @Column(nullable = false, unique = true)
    private String email;

    // varchar(19) not null
    @Column(nullable = false, length = 19, unique = true)
    private String senha;

    // DATETIME NOT NULL
    @Column(nullable = false)
    private LocalDate dataNascimento;


    private String status;

}
