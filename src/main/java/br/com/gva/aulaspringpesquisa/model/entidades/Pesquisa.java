package br.com.gva.aulaspringpesquisa.model.entidades;

import java.util.List;

import br.com.gva.aulaspringpesquisa.model.enums.EstadoCivil;
import br.com.gva.aulaspringpesquisa.model.enums.GeneroFilmes;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pesquisa {

    @EqualsAndHashCode.Include
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String sexo;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @Getter
    @Setter
    @ElementCollection(targetClass = GeneroFilmes.class, fetch = FetchType.LAZY)
    @JoinTable(name = "pesquisa_genero_filme_relation", joinColumns = 
        @JoinColumn(name = "pesquisa_id")
    )
    @Column(name = "tipo_genero", nullable = false)
    private List<GeneroFilmes> generosFilme;

}