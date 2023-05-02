package br.com.gva.aulaspringpesquisa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gva.aulaspringpesquisa.model.dto.UsuarioConsultaDTO;
import br.com.gva.aulaspringpesquisa.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioConsultaDTO> findAll(){
        List<UsuarioConsultaDTO> dtos = repository.findAll()
            .stream()
            .map( u -> new UsuarioConsultaDTO(u.getId(), u.getNome()))
            .collect(Collectors.toList());
        
        return dtos;
    }
    
}