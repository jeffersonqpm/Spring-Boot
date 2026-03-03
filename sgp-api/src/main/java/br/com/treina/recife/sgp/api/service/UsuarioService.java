// (O CÉREBRO): ONDE FICA A REGRA DE NEGÓCIO (VALIDAÇÕES, CÁLCULOS)

package br.com.treina.recife.sgp.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treina.recife.sgp.api.model.Usuario;
import br.com.treina.recife.sgp.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired // injetar o repository no service
    private UsuarioRepository usuarioRepository; // equivalente ao NEW. injetar dependencia do usuario repository

    // SELECT * FROM TB_USUARIO
    public List<Usuario> listarUsuarios() {

        // todo: Ocultar senha.

        return usuarioRepository.findAll();// retorna a lista de usuarios(findAll)

    }

    // SELECT * FROM TB_USUARIO WHERE ID = ?

    public Optional<Usuario> obterDadosDoUsuario(Long id) { // se não receber um ID no parametro o Optional retorna o
                                                            // null
        return usuarioRepository.findById(id); //findbyid é do optional
    }

    // INSERT INTO TB_USUARIOS VALUES ...

    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);

    }

    //UPDATE TB_USUARIOS .. WHERE ID = ?

    public Usuario atualizarUsuario(Long id, Usuario usuario){
        usuario.setId(id);
        return usuarioRepository.save(usuario);

    }

    // DELETE FROM TB_USUARIOS WHERE ID = ?
    public void excluirUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

}
