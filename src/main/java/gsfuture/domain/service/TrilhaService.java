package gsfuture.domain.service;

import gsfuture.api.dto.TrilhaRequestDTO;
import gsfuture.api.dto.TrilhaResponseDTO;
import gsfuture.domain.entity.Trilha;
import gsfuture.domain.exception.ResourceNotFoundException;
import gsfuture.domain.repository.TrilhaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrilhaService {

    private final TrilhaRepository repo;

    public TrilhaService(TrilhaRepository repo) {
        this.repo = repo;
    }

    public List<TrilhaResponseDTO> listar() {
        return repo.findAll().stream().map(this::map).toList();
    }

    public TrilhaResponseDTO buscar(Long id) {
        Trilha t = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada: " + id));
        return map(t);
    }

    public TrilhaResponseDTO criar(TrilhaRequestDTO dto) {
        Trilha novo = Trilha.builder()
                .nome(dto.nome())
                .descricao(dto.descricao())
                .nivel(dto.nivel())
                .cargaHoraria(dto.cargaHoraria())
                .focoPrincipal(dto.focoPrincipal())
                .build();
        return map(repo.save(novo));
    }

    public TrilhaResponseDTO atualizar(Long id, TrilhaRequestDTO dto) {
        Trilha t = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada: " + id));

        t.setNome(dto.nome());
        t.setDescricao(dto.descricao());
        t.setNivel(dto.nivel());
        t.setCargaHoraria(dto.cargaHoraria());
        t.setFocoPrincipal(dto.focoPrincipal());

        return map(repo.save(t));
    }

    public void remover(Long id) {
        if (!repo.existsById(id))
            throw new ResourceNotFoundException("Trilha não encontrada: " + id);

        repo.deleteById(id);
    }

    private TrilhaResponseDTO map(Trilha t) {
        return new TrilhaResponseDTO(
                t.getId(),
                t.getNome(),
                t.getDescricao(),
                t.getNivel(),
                t.getCargaHoraria(),
                t.getFocoPrincipal()
        );
    }
}
