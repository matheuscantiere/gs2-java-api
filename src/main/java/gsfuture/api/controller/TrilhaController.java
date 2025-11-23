package gsfuture.api.controller;

import gsfuture.api.dto.TrilhaRequestDTO;
import gsfuture.api.dto.TrilhaResponseDTO;
import gsfuture.domain.service.TrilhaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/trilhas")
public class TrilhaController {

    private final TrilhaService service;

    public TrilhaController(TrilhaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TrilhaResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrilhaResponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @PostMapping
    public ResponseEntity<TrilhaResponseDTO> criar(@Valid @RequestBody TrilhaRequestDTO dto) {
        TrilhaResponseDTO criado = service.criar(dto);
        URI uri = URI.create("/trilhas/" + criado.id());
        return ResponseEntity.created(uri).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrilhaResponseDTO> atualizar(@PathVariable Long id,
                                                       @Valid @RequestBody TrilhaRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
