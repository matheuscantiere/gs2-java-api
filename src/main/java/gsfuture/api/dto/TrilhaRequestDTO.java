package gsfuture.api.dto;

import gsfuture.domain.enums.NivelTrilha;
import jakarta.validation.constraints.*;

public record TrilhaRequestDTO(

        @NotBlank
        @Size(max = 150)
        String nome,

        @Size(max = 2000)
        String descricao,

        @NotNull
        NivelTrilha nivel,

        @NotNull
        @Min(1)
        Integer cargaHoraria,

        @Size(max = 100)
        String focoPrincipal
) {}
