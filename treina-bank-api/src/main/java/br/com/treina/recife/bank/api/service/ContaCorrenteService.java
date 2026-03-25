package br.com.treina.recife.bank.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treina.recife.bank.api.model.ContaCorrente;
import br.com.treina.recife.bank.api.repository.ContaCorrenteRepository;
@Service
public class ContaCorrenteService {

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    // fazer metodo cadastrar

    // public List<ContaCorrente> listarContasDoTitular(Long idTitular){
    //     return contaCorrenteRepository.save(contaCorrente);
    // }
    
}
