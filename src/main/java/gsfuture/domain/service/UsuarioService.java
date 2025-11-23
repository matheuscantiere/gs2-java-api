package gsfuture.domain.service;

import gsfuture.api.dto.UsuarioRequestDTO;
import gsfuture.api.dto.UsuarioResponseDTO;
import gsfuture.domain.entity.Usuario;
import gsfuture.domain.exception.ResourceNotFoundException;
import gsfuture.domain.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public List<UsuarioResponseDTO> listar() {
        return repo.findAll().stream().map(this::map).toList();
    }

    public UsuarioResponseDTO buscar(Long id) {
        Usuario u = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + id));
        return map(u);
    }

    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {
        Usuario novo = Usuario.builder()
                .nome(dto.nome())
                .email(dto.email())
                .areaAtuacao(dto.areaAtuacao())
                .nivelCarreira(dto.nivelCarreira())
                .dataCadastro(LocalDate.now())
                .build();
        return map(repo.save(novo));
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        Usuario u = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + id));

        u.setNome(dto.nome());
        u.setEmail(dto.email());
        u.setAreaAtuacao(dto.areaAtuacao());
        u.setNivelCarreira(dto.nivelCarreira());

        return map(repo.save(u));
    }

    public void remover(Long id) {
        if (!repo.existsById(id))
            throw new ResourceNotFoundException("Usuário não encontrado: " + id);

        repo.deleteById(id);
    }

    private UsuarioResponseDTO map(Usuario u) {
        return new UsuarioResponseDTO(
                u.getId(),
                u.getNome(),
                u.getEmail(),
                u.getAreaAtuacao(),
                u.getNivelCarreira(),
                u.getDataCadastro()
        );
    }
}
