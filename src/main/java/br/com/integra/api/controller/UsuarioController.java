package br.com.integra.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.integra.api.config.security.IntegraSecurity;
import br.com.integra.api.controller.swagger.UsuarioControllerSwagger;
import br.com.integra.api.dto.input.UsuarioInputDto;
import br.com.integra.api.dto.output.UsuarioOutputDto;
import br.com.integra.api.filter.UsuarioFilter;
import br.com.integra.api.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController implements UsuarioControllerSwagger{
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private IntegraSecurity security;
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){

			UsuarioOutputDto dto = service.findById(id);
			return ResponseEntity.ok(dto);
		}
	@Override
	@GetMapping
	public ResponseEntity<Page<UsuarioOutputDto>> findAll(Pageable pageable, UsuarioFilter filter){ 
		return ResponseEntity.ok(service.findAll(pageable, filter, security.getClienteId()));
	}

	@PostMapping
	@Override
	public ResponseEntity<UsuarioOutputDto> save(@RequestBody UsuarioInputDto user, UriComponentsBuilder uri) {
		
		UsuarioOutputDto dto = service.save(user, security.getClienteId());
		return ResponseEntity.created(uri.path("/usuario/{id}").buildAndExpand(dto.getId()).toUri()).body(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody UsuarioInputDto user, @PathVariable Long id) {
		
		return ResponseEntity.ok(service.update(id, user));
	}
	
	@PutMapping("/ativar/{id}")
	public UsuarioOutputDto ativarUsuario(@PathVariable Long id){
		UsuarioOutputDto user =service.enable(id);
		return user;
	}
	
	@PutMapping("/desativar/{id}")
	public UsuarioOutputDto desativarUsuario(@PathVariable Long id){
		UsuarioOutputDto user = service.disable(id);
		return user;
	}
	
}
