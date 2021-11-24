package br.com.integra.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.integra.api.dto.input.UsuarioInputDto;
import br.com.integra.api.dto.output.UsuarioOutputDto;
import br.com.integra.api.enums.StatusEnum;
import br.com.integra.api.enums.UsuarioGrupo;
import br.com.integra.api.exception.EntidadeNaoEncontradaException;
import br.com.integra.api.filter.UsuarioFilter;
import br.com.integra.api.mapper.UsuarioMapper;
import br.com.integra.api.model.Cliente;
import br.com.integra.api.model.Usuario;
import br.com.integra.api.repository.ClienteRepository;
import br.com.integra.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioMapper mapper;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	public UsuarioOutputDto save(UsuarioInputDto user, Long clienteId) {
		Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() ->
				new EntidadeNaoEncontradaException("Cliente não encontrado") {}) ;
		
		if(user.getGrupos().isEmpty())
		{
			user.getGrupos().add(UsuarioGrupo.NORMAL);
		}
		user.setSenha(passwordEncoder.encode(user.getSenha()));
		Usuario usuario = mapper.inputDtoToModel(user);
		
		if(user.getStatus() == null) {
			user.setStatus(StatusEnum.ATIVO);
		}
		
	
		usuario.setCliente(cliente);
		
		return mapper.modelToOutputDto(repository.save(usuario));
	}
	
	@SuppressWarnings("serial")
	@Transactional
	public UsuarioOutputDto update(Long id, UsuarioInputDto request) {
		
		Usuario model = repository.findById(id).orElseThrow(() -> new  EntidadeNaoEncontradaException("O Usuário de ID: "+id+" Não foi encontrado"){});
		BeanUtils.copyProperties(request, model, "id", "cliente");
		model.setSenha(passwordEncoder.encode(request.getSenha()));
		
		if(request.getStatus() == null) {
			model.setStatus(StatusEnum.ATIVO);
		}
		
		return mapper.modelToOutputDto(repository.save(model));
	}
	
	@SuppressWarnings("serial")
	@Transactional
	public void delete(Long id) {
		
		repository.findById(id).orElseThrow(() -> new  EntidadeNaoEncontradaException("O Usuário de ID: "+id+" Não foi encontrado"){});
		repository.deleteById(id);
	}
	
	@SuppressWarnings("serial")
	public UsuarioOutputDto findById(Long id){
		
		Usuario model = repository.findById(id).orElseThrow(() -> new  EntidadeNaoEncontradaException("O Usuário de ID: "+id+" Não foi encontrado"){});
		
		return mapper.modelToOutputDto(model);
	}
	
	public Page<UsuarioOutputDto> findAll(Pageable pageable, UsuarioFilter filter, Long clienteId) {	
		
		Page<Usuario> page =  repository.findAll(pageable, filter, clienteId);	
		return page.map(user -> mapper.modelToOutputDto(user));
	}
	
	public UsuarioOutputDto enable(Long id){
		Usuario user = repository.findById(id).orElseThrow(() -> new  EntidadeNaoEncontradaException("O Usuário de ID: "+id+" Não foi encontrado"){});
		
		user.setStatus(StatusEnum.ATIVO);
		repository.save(user);
		return mapper.modelToOutputDto(user);
	}
	
	public UsuarioOutputDto disable(Long id){
		Usuario user = repository.findById(id).orElseThrow(() -> new  EntidadeNaoEncontradaException("O Usuário de ID: "+id+" Não foi encontrado"){});
		user.setStatus(StatusEnum.INATIVO);
		repository.save(user);
		return mapper.modelToOutputDto(user);
	}

	
		
}
