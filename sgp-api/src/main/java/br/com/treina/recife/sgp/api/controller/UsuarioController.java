//RECEBE A REQUISIÇÃO HTTP (O PEDIDO DO USUÁRIO/CLIENTE). endpoints

package br.com.treina.recife.sgp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Usuario cadastrar(@RequestBody Usuario usuario) { // @RequestBody corpo da requisiçao

            return usuarioService.cadastrarUsuario(usuario);

    }

    // @PostMapping
    // public void excluir(Long id){
    //     usuarioService.excluirUsuario(id);
    // }

}
