package gsfuture.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 150, unique = true)
    private String email;

    @Column(length = 100)
    private String areaAtuacao;

    @Column(length = 50)
    private String nivelCarreira;

    @Column(nullable = false)
    private LocalDate dataCadastro;
}
