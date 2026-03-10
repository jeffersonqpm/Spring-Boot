// (O Arquivo): O único autorizado a falar diretamente com o Banco de Dados

package br.com.treina.recife.sgp.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.treina.recife.sgp.api.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    Optional<Usuario> findByEmail(String email);

    List<Usuario> findByStatus(String status);
    
}
