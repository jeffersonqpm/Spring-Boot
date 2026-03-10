package br.com.treina.recife.sgp.api.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.treina.recife.sgp.api.enums.PrioridadeTarefa;
import br.com.treina.recife.sgp.api.enums.StatusTarefa;
import br.com.treina.recife.sgp.api.model.Projeto;
import br.com.treina.recife.sgp.api.model.Usuario;

public record TarefaDTO(

        Long id,
        String titulo,
        String descricao,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataCriacao,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataConclusao,
        PrioridadeTarefa prioridade,
        StatusTarefa status,
        Usuario usuario,
        Projeto projeto) {

}