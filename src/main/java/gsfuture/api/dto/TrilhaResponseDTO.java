package gsfuture.api.dto;

import gsfuture.domain.enums.NivelTrilha;

public record TrilhaResponseDTO(
        Long id,
        String nome,
        String descricao,
        NivelTrilha nivel,
        Integer cargaHoraria,
        String focoPrincipal
) {}
