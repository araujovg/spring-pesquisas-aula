package br.com.gva.aulaspringpesquisa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gva.aulaspringpesquisa.model.dto.PesquisaInserirDto;
import br.com.gva.aulaspringpesquisa.service.PesquisaService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.Getter;

@Controller
@RequestMapping("/pesquisas")
public class PesquisaController {

    @Autowired @Getter
    private PesquisaService service;

    @GetMapping("/formulario-pesquisa")
    public String carregaFormulario(Model model){
        model.addAttribute("pesquisa", new PesquisaInserirDto());
        return "form-pesquisa";
    }

    @GetMapping
    public String procurarTodos(Model model){
        model.addAttribute("pesquisas", service.findAll());
        return "lista-pesquisas";
    }

    @PostMapping
    public String salvar( @ModelAttribute("pesquisa") @Valid PesquisaInserirDto pesquisa, Errors errors) throws Exception{
       if(!errors.hasErrors()){
        getService().salvar(pesquisa);
       }
       return "form-pesquisa";
    }

    @GetMapping("/remover")
    public String deletar(@PathParam("id") Long id) {
        service.removerPeloId(id);
        return "redirect:/pesquisas";
    }
}