package br.com.integra.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.integra.api.dto.input.UsuarioInputDto;
import br.com.integra.api.dto.output.UsuarioOutputDto;
import br.com.integra.api.exception.EntidadeNaoEncontradaException;
import br.com.integra.api.mapper.UsuarioMapper;
import br.com.integra.api.model.Usuario;
import br.com.integra.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repository;
	
	@Autowired
	UsuarioMapper mapper;

	@Transactional
	public UsuarioOutputDto save(UsuarioInputDto user) {
		
		Usuario savedModel = repository.save(mapper.inputDtoToModel(user));
		
		return mapper.modelToOutputDto(savedModel);
	}
	
	@SuppressWarnings("serial")
	@Transactional
	public UsuarioOutputDto update(Long id, UsuarioInputDto request) {
		
		Usuario model = repository.findById(id).orElseThrow(() -> new  EntidadeNaoEncontradaException("O Usuário de ID: "+id+" Não foi encontrado"){});
		BeanUtils.copyProperties(request, model, "id");
		
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
	
	public void enable(Long id){
		Usuario user = repository.findById(id).get();
		user.setAtivo(1);
		repository.save(user);
	}
	
	public void disable(Long id){
		Usuario user = repository.findById(id).get();
		user.setAtivo(0);
		repository.save(user);
	}
		
}
