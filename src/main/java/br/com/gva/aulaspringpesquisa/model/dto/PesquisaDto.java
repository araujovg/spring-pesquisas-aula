package br.com.gva.aulaspringpesquisa.model.dto;

import java.util.List;

import br.com.gva.aulaspringpesquisa.model.enums.EstadoCivil;
import br.com.gva.aulaspringpesquisa.model.enums.GeneroFilmes;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PesquisaDto {

    private Long id;

    private String nome;

    private String email;

    private String sexo;

    private EstadoCivil estadoCivil;

    private List<GeneroFilmes> generosFilme;
    
}