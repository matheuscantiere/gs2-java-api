package gsfuture.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDTO(

        @NotBlank(message = "Nome é obrigatório")
        @Size(max = 100)
        String nome,

        @NotBlank(message = "Email é obrigatório")
        @Email
        String email,

        @Size(max = 100)
        String areaAtuacao,

        @Size(max = 50)
        String nivelCarreira
) {}
