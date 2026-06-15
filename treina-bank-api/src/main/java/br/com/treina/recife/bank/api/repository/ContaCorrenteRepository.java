package br.com.treina.recife.bank.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.treina.recife.bank.api.model.ContaCorrente;

@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long>{


    List<ContaCorrente> findByConta_Titular_id(Long idTitular);

    //SELECT * FROM TB_CONTAS_CORRENT WHERE LIMITE_CHEQUE_ESPECIAL >=?
    List<ContaCorrente> findByLimiteChequeEspecialGreaterThanEqual(Double limiteChequeEspecial);

    
} 