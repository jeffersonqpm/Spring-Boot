package br.com.treina.recife.sgp.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treina.recife.sgp.api.dto.DadosProjetoDTO;
import br.com.treina.recife.sgp.api.dto.ProjetoDTO;
import br.com.treina.recife.sgp.api.model.Projeto;
import br.com.treina.recife.sgp.api.model.Usuario;
import br.com.treina.recife.sgp.api.repository.ProjetoRepository;
import br.com.treina.recife.sgp.api.repository.UsuarioRepository; // Certifique-se de que este import existe

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository; // <-- Adicionado para buscar o responsável real

    // SELECT * FROM TB_PROJETOS
    public List<ProjetoDTO> listaProjetos() {
        List<Projeto> projetos = projetoRepository.findAll();
        List<ProjetoDTO> dtos = new ArrayList<>();

        for (Projeto projeto : projetos) {
            dtos.add(projeto.toDTO());
        }

        return dtos;
    }

    // SELECT * FROM TB_PROJETOS WHERE ID = ?
    public ProjetoDTO obterDadosDeProjetos(long id) {
        Optional<Projeto> projeto = projetoRepository.findById(id);

        if (projeto.isPresent()) {
            return projeto.get().toDTO();
        }
        return null;
    }

    // INSERT INTO TB_PROJETOS VALUES ...
    public Projeto cadastraProjeto(DadosProjetoDTO dados) {
        // 1. Busca o usuário gerenciado pelo Hibernate
        Usuario usuarioReal = usuarioRepository.findById(dados.responsavelId())
            .orElseThrow(() -> new RuntimeException("Usuário com ID " + dados.responsavelId() + " não encontrado."));

        // 2. Converte o DTO para a Model
        Projeto projeto = dados.toModel();
        
        // 3. Associa o usuário real recuperado do banco
        projeto.setResponsavel(usuarioReal);

        // 4. Salva com segurança
        return projetoRepository.save(projeto);
    }

    // UPDATE TB_PROJETOS .. WHERE ID = ?
    public Projeto atualizaProjeto(Long id, DadosProjetoDTO dados) {
        // 1. Busca o usuário gerenciado para evitar erro de objeto transiente no update também
        Usuario usuarioReal = usuarioRepository.findById(dados.responsavelId())
            .orElseThrow(() -> new RuntimeException("Usuário com ID " + dados.responsavelId() + " não encontrado."));

        // 2. Converte o DTO para a Model
        Projeto projeto = dados.toModel();

        // 3. Seta as informações necessárias
        projeto.setId(id);
        projeto.setResponsavel(usuarioReal);
        
        return projetoRepository.save(projeto);
    }

    // DELETE FROM TB_PROJETOS WHERE ID = ?
    public void excluirTarefa(Long id) {
        projetoRepository.deleteById(id);
    }

    // SELECT * FROM TB_PROJETOS WHERE USUARIO_RESP_ID = ?
    public List<Projeto> listarProjetoDeUmUsuario(Long idUsuario){
        return projetoRepository.findByResponsavel_id(idUsuario);
    }
}

// package br.com.treina.recife.sgp.api.service;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import br.com.treina.recife.sgp.api.dto.DadosProjetoDTO;
// import br.com.treina.recife.sgp.api.dto.ProjetoDTO;
// import br.com.treina.recife.sgp.api.model.Projeto;
// import br.com.treina.recife.sgp.api.repository.ProjetoRepository;

// @Service
// public class ProjetoService {

//     @Autowired
//     private ProjetoRepository projetoRepository;

//     // SELECT * FROM TB_PROJETOS

//     public List<ProjetoDTO> listaProjetos() {

//         List<Projeto> projetos = projetoRepository.findAll();

//         List<ProjetoDTO> dtos = new ArrayList<>();

//         for (Projeto projeto : projetos) {

//             dtos.add(projeto.toDTO());

//         }

//         return dtos;

//     }

//     // SELECT * FROM TB_PROJETOS WHERE ID = ?

//     // public Optional<Projeto> obeterDadosDoUsuario(Long id) {

//     // return projetoRepository.findById(id);
//     // }

//     public ProjetoDTO obterDadosDeProjetos(long id) {

//         Optional<Projeto> projeto = projetoRepository.findById(id);

//         if (projeto.isPresent()) {
//             return projeto.get().toDTO();

//         }
//         return null;

//     }

//     // INSERT INTO TB_PROJETOS VALUES ...

//     // public Projeto cadastraProjeto(Projeto projeto) {
//     //     return projetoRepository.save(projeto);
//     // }

//         public Projeto cadastraProjeto(DadosProjetoDTO projeto) {
//         return projetoRepository.save(projeto.toModel());
//     }

//     // UPDATE TB_USUARIOS .. WHERE ID = ?

//     public Projeto atualizaProjeto(Long id, DadosProjetoDTO dados) {
//         Projeto projeto = dados.toModel();

//         projeto.setId(id);
//         return projetoRepository.save(projeto);
//     }

//     // DELETE FROM TB_TAREFAS WHERE ID?

//     public void excluirTarefa(Long id) {
//         projetoRepository.deleteById(id);
//     }

//     //select * from tb_projetos where usurio_resp_id = ?
//     public List<Projeto> listarProjetoDeUmUsuario(Long idUsuario){
//         return projetoRepository.findByResponsavel_id(idUsuario);
//     }
// }
