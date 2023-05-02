package br.com.gva.aulaspringpesquisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gva.aulaspringpesquisa.model.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}