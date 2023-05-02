package br.com.gva.aulaspringpesquisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gva.aulaspringpesquisa.model.entidades.Pesquisa;

public interface PesquisaRepository extends JpaRepository<Pesquisa, Long>{

    Pesquisa findByIdAndNome(Long id, String nome);
    
}