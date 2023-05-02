package br.com.gva.aulaspringpesquisa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gva.aulaspringpesquisa.model.dto.UsuarioConsultaDTO;
import br.com.gva.aulaspringpesquisa.service.UsuarioService;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioConsultaDTO>> usuarios(){
        return ResponseEntity.ok(service.findAll());
    }
    
}