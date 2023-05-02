package br.com.gva.aulaspringpesquisa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gva.aulaspringpesquisa.model.dto.PesquisaDto;
import br.com.gva.aulaspringpesquisa.model.dto.PesquisaInserirDto;
import br.com.gva.aulaspringpesquisa.model.dto.PesquisaListaDTO;
import br.com.gva.aulaspringpesquisa.model.entidades.Pesquisa;
import br.com.gva.aulaspringpesquisa.repository.PesquisaRepository;
import lombok.Getter;

@Service
public class PesquisaService {

    @Autowired
    @Getter
    private PesquisaRepository repository;

    public PesquisaDto salvar(PesquisaInserirDto pesquisaDto) {
        Pesquisa pesquisa = dto2PesquisaBuilder(pesquisaDto);
        pesquisa = getRepository().save(pesquisa);
        return pesquisa2PesquisaDtoBuilder(pesquisa);
    }

    public List<PesquisaListaDTO> findAll() {
        return listaPesquisa2ListaPesquisaListaDTO(repository.findAll());
    }

    private Pesquisa dto2PesquisaBuilder(PesquisaInserirDto pesquisaInserirDto) {
        return Pesquisa.builder()
                .nome(pesquisaInserirDto.getNome())
                .email(pesquisaInserirDto.getEmail())
                .sexo(pesquisaInserirDto.getSexo())
                .estadoCivil(pesquisaInserirDto.getEstadoCivil())
                .generosFilme(pesquisaInserirDto.getGenerosFilme())
                .build();
    }

    private PesquisaDto pesquisa2PesquisaDtoBuilder(Pesquisa pesquisa) {
        return PesquisaDto.builder()
                .id(pesquisa.getId())
                .nome(pesquisa.getNome())
                .email(pesquisa.getEmail())
                .sexo(pesquisa.getSexo())
                .estadoCivil(pesquisa.getEstadoCivil())
                .generosFilme(pesquisa.getGenerosFilme())
                .build();
    }

    private List<PesquisaListaDTO> listaPesquisa2ListaPesquisaListaDTO(List<Pesquisa> pesquisas) {
        return pesquisas.stream().map(pesquisa -> new PesquisaListaDTO(pesquisa.getId(), pesquisa.getNome(),
                pesquisa.getSexo(), pesquisa.getEstadoCivil(), pesquisa.getGenerosFilme()))
                .collect(Collectors.toList());
    }

    public void removerPeloId(Long id) {
        repository.deleteById(id);
    }

}