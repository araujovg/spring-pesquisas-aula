package br.com.gva.aulaspringpesquisa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gva.aulaspringpesquisa.model.entidades.Pesquisa;
import br.com.gva.aulaspringpesquisa.model.entidades.Usuario;
import br.com.gva.aulaspringpesquisa.model.enums.EstadoCivil;
import br.com.gva.aulaspringpesquisa.model.enums.GeneroFilmes;
import br.com.gva.aulaspringpesquisa.repository.PesquisaRepository;
import br.com.gva.aulaspringpesquisa.repository.UsuarioRepository;

@SpringBootApplication
public class AulaSpringPesquisaApplication implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PesquisaRepository pesquisaRepository;

	public static void main(String[] args) {
		SpringApplication.run(AulaSpringPesquisaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario usuario = Usuario.builder()
			.id(null)
			.nome("Teste 1")
			.senha("1234")
			.build();

		Usuario usuario2 = new Usuario(null, "Teste 2", "1234");

		Usuario usuario3 = new Usuario();
		usuario3.setNome("Teste 3");
		usuario3.setSenha("1234");

		usuarioRepository.saveAll(List.of(usuario, usuario2, usuario3));

		//*********************************************************

		var p1 =  Pesquisa.builder()
			.nome("Bruce Wayne")
			.email("bruce@wayneenterprises.com")
			.sexo("masculino")
			.estadoCivil(EstadoCivil.SOLTEIRO)
			.generosFilme(List.of(GeneroFilmes.ACAO, GeneroFilmes.FICCAO, GeneroFilmes.COMEDIA))
			.build();

		var p2 =  Pesquisa.builder()
			.nome("Marta Wayne")
			.email("marta@wayneenterprises.com")
			.sexo("feminino")
			.estadoCivil(EstadoCivil.VIUVO)
			.generosFilme(List.of(GeneroFilmes.ROMANCE, GeneroFilmes.FICCAO))
			.build();

		var p3 =  Pesquisa.builder()
			.nome("Clarck Kent")
			.email("kent@planetdiary.com")
			.sexo("masculino")
			.estadoCivil(EstadoCivil.CASADO)
			.generosFilme(List.of(GeneroFilmes.ACAO, GeneroFilmes.FICCAO, GeneroFilmes.ANIMACAO))
			.build();
		
			pesquisaRepository.saveAll(List.of(p1,p2,p3));
	}
}
