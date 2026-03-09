//RECEBE A REQUISIÇÃO HTTP (O PEDIDO DO USUÁRIO/CLIENTE). endpoints
package br.com.treina.recife.sgp.api.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.treina.recife.sgp.api.dto.UsuarioDTO;
import br.com.treina.recife.sgp.api.model.Usuario;
import br.com.treina.recife.sgp.api.service.UsuarioService;

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
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) { // @RequestBody pega o corpo da requisição
                                                                             // HTTP e transforma em um objeto java

        // return usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)// retorna 2001
                .body(usuarioService.cadastrarUsuario(usuario));
    }

    @GetMapping
    // public ResponseEntity<List<Usuario>> listar() {
    public ResponseEntity<List<UsuarioDTO>> listar() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());// retorna 200
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> ObterDadosPeloId(@PathVariable Long id) { // @PathVariable a variavel vem no endpoint
        Optional<Usuario> usuario = usuarioService.obterDadosDoUsuario(id);

        if (usuario.isEmpty()) {
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found status

        }

        return ResponseEntity.ok(usuario.get()); // HTTP 200
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.obterDadosDoUsuario(id);

        if (usuario.isEmpty()) {
            return ResponseEntity.notFound().build();

        }

        usuarioService.excluirUsuario(id);

        return ResponseEntity.noContent().build(); // noContent(): retorna HTTP 204, body vazio

    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario dados) {
        Optional<Usuario> usuario = usuarioService.obterDadosDoUsuario(id);

        if (usuario.isEmpty()) {
            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(usuarioService.atualizarUsuario(id, dados));

    }

}
