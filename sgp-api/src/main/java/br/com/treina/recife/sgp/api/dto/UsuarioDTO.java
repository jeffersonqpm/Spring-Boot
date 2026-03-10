package br.com.treina.recife.sgp.api.dto;

import java.time.LocalDate;
// import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.treina.recife.sgp.api.enums.StatusUsuario;

public record UsuarioDTO(
        Long id,
        String nome,
        String cpf,
        String email,
        @JsonFormat(pattern = "dd/MM/yyyy")
         LocalDate dataNascimento,
        Integer idade,
        StatusUsuario status) {

}
