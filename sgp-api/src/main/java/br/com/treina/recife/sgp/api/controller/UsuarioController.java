//RECEBE A REQUISIÇÃO HTTP (O PEDIDO DO USUÁRIO/CLIENTE). endpoints

package br.com.treina.recife.sgp.api.controller;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

// import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treina.recife.sgp.api.model.Usuario;
import br.com.treina.recife.sgp.api.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping // metodo http que chama o requestmapping (api/usuarios)
    // public Usuario cadastrar(@RequestBody Usuario usuario) { // @RequestBody
    // corpo da requisiçao
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) { // @RequestBody corpo da requisiçao

        // return usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.cadastrarUsuario(usuario));// retorna 2001
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());// retorn 200
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> ObterDadosPeloId(@PathVariable Long id) { //@PathVariable a variavel vem no endpoint
        Optional<Usuario> usuario = usuarioService.obterDadosDoUsuario(id);

        if(usuario.isEmpty()){
            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(usuario.get());
    }

}
