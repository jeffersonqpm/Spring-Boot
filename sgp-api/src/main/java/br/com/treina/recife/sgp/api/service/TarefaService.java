package br.com.treina.recife.sgp.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treina.recife.sgp.api.model.Tarefa;
import br.com.treina.recife.sgp.api.repository.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    // SELECT * FROM TB_TAREFA

    public List<Tarefa> listarTarefas() {

        return tarefaRepository.findAll();
    }

    // SELECT * FROM TB_TAREFAS WHERE ID = ?

    public Optional<Tarefa> obeterDadosDeTarefa(Long id) {

        return tarefaRepository.findById(id);

    }

    // INSERT INTO TB_TAREFAS VALUES ...

    public Tarefa cadastrarTarefa(Tarefa tarefa) {

        return tarefaRepository.save(tarefa);

    }

    // UPDATE TB_TAREFAS ... WHERE ID = ?

    public Tarefa atualizaTarefa(Long id, Tarefa tarefa) {
        tarefa.setId(id);
        return tarefaRepository.save(tarefa);
    }

    // DELETE FROM TB_TAREFAS WHERE ID = ?

    public void excluirTarefa(Long id) {

        tarefaRepository.deleteById(id);
    }

}
