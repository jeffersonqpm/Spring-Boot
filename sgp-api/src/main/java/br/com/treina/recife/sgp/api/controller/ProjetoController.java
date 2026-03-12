package br.com.treina.recife.sgp.api.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treina.recife.sgp.api.dto.ProjetoDTO;
import br.com.treina.recife.sgp.api.dto.UsuarioDTO;
import br.com.treina.recife.sgp.api.model.Projeto;
import br.com.treina.recife.sgp.api.service.ProjetoService;
import br.com.treina.recife.sgp.api.service.UsuarioService;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;
    // ProjetoService projetoService = new ProjetoService();
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<ProjetoDTO> cadastrar(@RequestBody Projeto projeto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(projetoService.cadastraProjeto(projeto).toDTO());// retorna 2001
    }

    // @GetMapping
    // public ResponseEntity<List<Projeto>> listar() {
    // return ResponseEntity.ok(projetoService.listaProjetos()); // retorna 200
    // }

    @GetMapping
    public ResponseEntity<List<ProjetoDTO>> listar() {
        return ResponseEntity.ok(projetoService.listaProjetos()); // retorna 200
    }

    @GetMapping("{id}")
    public ResponseEntity<ProjetoDTO> obterDadosPorId(@PathVariable Long id) {

        ProjetoDTO projeto = projetoService.obterDadosDeProjetos(id);

        if (Objects.isNull(projeto)) {

            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(projeto);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        ProjetoDTO projeto = projetoService.obterDadosDeProjetos(id);

        if (Objects.isNull(projeto)) {

            return ResponseEntity.notFound().build();

        }

        projetoService.excluirTarefa(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("{id}")
    public ResponseEntity<ProjetoDTO> atualizar(@PathVariable Long id, @RequestBody Projeto dadosProjeto) {
        ProjetoDTO projeto = projetoService.obterDadosDeProjetos(id);

        if (Objects.isNull(projeto)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(projetoService.atualizaProjeto(id, dadosProjeto).toDTO());
    }

    // @GetMapping("/usuario/{id}")
    // public ResponseEntity<List<Projeto>> listarPeloResponsavel(@PathVariable("id") Long idUsuario){

    //     UsuarioDTO usuario = usuarioService.obterDadosUsuario(idUsuario);

    //     if(Objects.isNull(usuario)){
    //         return ResposeEntity.notFound().build();
    //     }
        
    //     return ResposeEntity.ok(projetoService.listarProjetosDeUmUsuario(idUsuario));
        

    // }
}
