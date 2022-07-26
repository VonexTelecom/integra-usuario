package br.com.integra.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.integra.api.filter.UsuarioFilter;
import br.com.integra.api.model.Usuario;

public interface UsuarioFilterRepository {
	Page<Usuario> findAll(Pageable page, UsuarioFilter filter, Long clienteId);
}
