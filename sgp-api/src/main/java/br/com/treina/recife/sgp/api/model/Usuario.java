package br.com.treina.recife.sgp.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;

import java.time.LocalDate;

//import jakarta.annotation.Generated;

import br.com.treina.recife.sgp.api.enums.StatusUsuario;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data// cria get sets 
@NoArgsConstructor // CRIA O CONSTRUTUOR SEM ARGUMENTOS
@AllArgsConstructor // CRIA O CONTRUTOR COM OS ARGUMENTOS
@Entity(name = "TB_USUARIOS") // DIZ AO SPRING QUE ESSA CLASSE É UMA TABELA.

public class Usuario {
    @Id // DEFINE A CHAVE PRIMÁRIA (PK).
    @GeneratedValue(strategy = GenerationType.IDENTITY)//DEFINE A CHAVE PRIMÁRIA (PK).
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

    // NOT NULL e 
    @Column(nullable = false)
    //  mapear um campo de enumeração (enum)
    @Enumerated(EnumType.STRING)
    private StatusUsuario status;

    

}
