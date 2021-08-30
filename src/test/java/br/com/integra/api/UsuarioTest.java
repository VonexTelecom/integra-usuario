package br.com.integra.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.integra.api.enums.StatusEnum;
import br.com.integra.api.enums.UsuarioGrupo;
import br.com.integra.api.exception.EntidadeNaoEncontradaException;
import br.com.integra.api.model.Cliente;
import br.com.integra.api.model.Usuario;
import br.com.integra.api.repository.UsuarioRepository;
import br.com.integra.api.service.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioTest {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	UsuarioService usuarioService;

	@Test
	public void buscarUsuarioSucesso() throws Exception {
		List<UsuarioGrupo> lista = new ArrayList<>();
		lista.add(UsuarioGrupo.NORMAL);
		Usuario usuario = Usuario.builder()
				.id(1L)
				.nome("Rodrigo")	
				.email("rodrigo@gmail.com")
				.usuario("rodrigo.nunes")
				.senha("$2a$10$7piXDrZUpm7ErxVk7BVEPu5waHYxBl8cL7ht.fEjf5cV0uOY1hAlG")
				.status(StatusEnum.ATIVO)
				.dataDeCriacao(new Date(2021-8-20))
				.grupos(lista)
				.cliente(new Cliente(1L, "Exito", 1))
				.build();
				
				Usuario newUsuario = usuarioRepository.save(usuario);

				assertThat(newUsuario).isNotNull();
	}	
	
	@Test
	public void salvarUsuarioSucesso() throws Exception {
		List<UsuarioGrupo> lista = new ArrayList<>();
		lista.add(UsuarioGrupo.NORMAL);
		Usuario usuario = Usuario.builder()
				.id(1L)
				.nome("Rodrigo")
				.email("rodrigo@gmail.com")
				.usuario("rodrigo.nunes")
				.senha("$2a$10$7piXDrZUpm7ErxVk7BVEPu5waHYxBl8cL7ht.fEjf5cV0uOY1hAlG")
				.status(StatusEnum.ATIVO)
				.dataDeCriacao(new Date(2021-8-20))
				.grupos(lista)
				.cliente(new Cliente(1L, "Exito", 1))
				.build();
				
				Usuario newUsuario = usuarioRepository.save(usuario);

				assertThat(newUsuario).isNotNull();
	}	
	

	@Test
	public void atualizarUsuarioSucesso() throws Exception {

		Usuario usuario = usuarioRepository.findById(1L).orElseThrow(() -> new EntidadeNaoEncontradaException("Usuário não encontrado") {
			private static final long serialVersionUID = 7154716946021059116L;
		});
		
		List<UsuarioGrupo> lista = new ArrayList<>();
		lista.add(UsuarioGrupo.NORMAL);
		Usuario newUsuario = new Usuario(
				1L, "Rodrigo", "rodrigo@gmail.com", "rodrigo.nunes", "$2a$10$7piXDrZUpm7ErxVk7BVEPu5waHYxBl8cL7ht.fEjf5cV0uOY1hAlG", 
				StatusEnum.ATIVO, new Date(2021-8-20), lista, new Cliente(1L, "Exito", 1));
		
		usuario.setUsuario(newUsuario);
		usuarioRepository.save(usuario);
		usuario = usuarioRepository.findById(1L).get();

		
		assertThat(usuario.getUsuario()).isNotEqualTo(newUsuario);

	}

	@Test
	public void deletarUsuarioSucesso() throws Exception {

		Optional<Usuario> usuario = usuarioRepository.findById(1L);

		usuarioRepository.delete(usuario.get());

		usuario = usuarioRepository.findById(1L);

		assertThat(usuario.isPresent()).isFalse();
	}
				

}
