package br.com.treina.recife.sgp.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treina.recife.sgp.api.model.Projeto;
import br.com.treina.recife.sgp.api.repository.ProjetoRepository;

@Service
public class ProjetoService {

   

    @Autowired
    private ProjetoRepository projetoRepository;

    // SELECT * FROM TB_PROJETOS

    public List<Projeto> listaProjetos() {

        return projetoRepository.findAll();

    }

    // SELECT * FROM TB_PROJETOS WHERE ID = ?

    public Optional<Projeto> obeterDadosDoUsuario(Long id) {

        return projetoRepository.findById(id);
    }

    // INSERT INTO TB_PROJETOS VALUES ...

    public Projeto cadastraProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    // UPDATE TB_USUARIOS .. WHERE ID = ?

    public Projeto atualizaProjeto(Long id, Projeto projeto) {

        projeto.setId(id);
        return projetoRepository.save(projeto);
    }

    // DELETE FROM TB_TAREFAS WHERE ID?

    public void excluirTarefa(Long id) {
        projetoRepository.deleteById(id);
    }
}
