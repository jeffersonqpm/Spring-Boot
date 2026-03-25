//RECEBE A REQUISIÇÃO HTTP (O PEDIDO DO USUÁRIO/CLIENTE). endpoints
package br.com.treina.recife.sgp.api.controller;

import java.util.List;
import java.util.Objects;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.treina.recife.sgp.api.dto.CredenciaisDTO;
import br.com.treina.recife.sgp.api.dto.DadosUsuarioDTO;
import br.com.treina.recife.sgp.api.dto.UsuarioDTO;
import br.com.treina.recife.sgp.api.model.Usuario;
import br.com.treina.recife.sgp.api.service.UsuarioService;
import jakarta.validation.Valid;

@RestController // faz a conversão Java -> Jason para enviar a resposta
@RequestMapping("/api/usuarios")
public class UsuarioController {
    // teste

    @Autowired // instanciar, gerenciar e conectar automaticamente os objetos, eliminando a
               // necessidade de criar manualmente o "new"
    private UsuarioService usuarioService;

    @PostMapping // metodo http que chama o requestmapping (api/usuarios)
    // public Usuario cadastrar(@RequestBody Usuario usuario) { // @RequestBody
    // corpo da requisiçao
    public ResponseEntity<UsuarioDTO> cadastrar( @Valid @RequestBody DadosUsuarioDTO usuario) { 
        // @RequestBody pega o corpo da
    // @Valid: serve para executar as validações de cada atibuto de DadosUsuarioDTO     
    // requisição
     // HTTP e transforma em um objeto java

        // return usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)// retorna 2001
                .body(usuarioService.cadastrarUsuario(usuario).toDTO());
    }

    @GetMapping
    // public ResponseEntity<List<Usuario>> listar() {
    public ResponseEntity<List<UsuarioDTO>> listar() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());// retorna 200
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioDTO> ObterDadosPeloId(@PathVariable Long id) { // @PathVariable a variavel vem no
                                                                                // endpoint
        UsuarioDTO usuario = usuarioService.obterDadosDoUsuario(id);

        if (Objects.isNull(usuario)) {// usuario == null
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found status

        }

        return ResponseEntity.ok(usuario); // HTTP 200
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        UsuarioDTO usuario = usuarioService.obterDadosDoUsuario(id);

        if (Objects.isNull(usuario)) {
            return ResponseEntity.notFound().build();

        }

        usuarioService.excluirUsuario(id);

        return ResponseEntity.noContent().build(); // noContent(): retorna HTTP 204, body vazio

    }

    @PutMapping("{id}")
    public ResponseEntity<UsuarioDTO> atualizar(@Valid @PathVariable Long id, @RequestBody DadosUsuarioDTO dados) {
        // Optional<Usuario> usuario = usuarioService.obterDadosDoUsuario(id);
        UsuarioDTO usuario = usuarioService.obterDadosDoUsuario(id);

        if (Objects.isNull(usuario)) {
            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(usuarioService.atualizarUsuario(id, dados).toDTO());

    }
    
        @GetMapping("/busca")
    public ResponseEntity<UsuarioDTO> consultarPeloCpf(@RequestParam String cpf) {
        UsuarioDTO usuario = usuarioService.buscarUsuarioPeloCpf(cpf);

        if (Objects.isNull(usuario)) {

            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/buscaPorCredencias")
    public ResponseEntity<UsuarioDTO> consultarPelasCredencias(@RequestBody CredenciaisDTO credencias){
        UsuarioDTO usuario = usuarioService.buscarUsuarioPeloEmailSenha(credencias.email(), credencias.senha());

        if(Objects.isNull(usuario)){

            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.notFound().build();
    }

    

}
