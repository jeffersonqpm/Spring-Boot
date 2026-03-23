package br.com.treina.recife.bank.api.model;

// import br.com.treina.recife.bank.api.DTO.ContaDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Embeddable // os atributos da classa sera inseridos em CC e CP (Herança)
public class Conta {

    @Column(nullable = false)
    private Long idBanco;

    @Column(nullable = false)
    private Long numAgencia;

    @Column(nullable = false)
    private String numConta;

    @Column(nullable = false)
    private Integer digito;

    @Column(nullable = false)
    private Double saldo = 0.0;

    @ManyToOne
    @JoinColumn(nullable = false, name = "titular_id")
    private Titular titular;

    // public ContaDTO toDTO() {

    //     return new ContaDTO(
    //             idBanco,
    //             numAgencia,
    //             numConta,
    //             digito,
    //             saldo,
    //             titular);
    // }

}
