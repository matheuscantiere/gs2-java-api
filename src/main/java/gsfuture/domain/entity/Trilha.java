package gsfuture.domain.entity;

import gsfuture.domain.enums.NivelTrilha;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trilhas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trilha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private NivelTrilha nivel;

    @Column(nullable = false)
    private Integer cargaHoraria;

    @Column(length = 100)
    private String focoPrincipal;
}
