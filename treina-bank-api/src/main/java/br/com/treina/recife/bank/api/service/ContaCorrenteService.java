package br.com.treina.recife.bank.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.treina.recife.bank.api.repository.ContaCorrenteRepository;

public class ContaCorrenteService {

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    // fazer metodo cadastrar

    public List<ContaConrrente> listarContasDoTitular(Long idTitular){
        return contaCorrenteRepository.save(contaCorrente);
    }
    
}
