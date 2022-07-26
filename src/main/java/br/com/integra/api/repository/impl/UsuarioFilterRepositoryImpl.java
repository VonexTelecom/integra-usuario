package br.com.integra.api.repository.impl;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.com.integra.api.filter.UsuarioFilter;
import br.com.integra.api.model.Usuario;
import br.com.integra.api.repository.UsuarioFilterRepository;

@Repository
public class UsuarioFilterRepositoryImpl implements UsuarioFilterRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public Page<Usuario> findAll(Pageable pageable, UsuarioFilter filter, Long clienteId) {
		StringBuilder jpql = new StringBuilder();
		HashMap<String, Object> parameter = new HashMap<String, Object>();
		
		jpql.append("Select distinct u from Usuario u left join u.grupos g where 0=0 ");
		
		if(filter.getGrupo() != null) {
			jpql.append("and g.id = :grupo ");
			parameter.put("grupo", Long.valueOf(filter.getGrupo().getValor()));
		}
		
		if(filter.getStatus() != null) {
			jpql.append("and u.status = :status ");
			parameter.put("status", filter.getStatus());
		}
		jpql.append("and u.cliente.id = :cliente");
		parameter.put("cliente", clienteId);
		
		TypedQuery<Usuario> query = manager.createQuery(jpql.toString(), Usuario.class);
		parameter.forEach((key, value) -> query.setParameter(key, value));
		Long size = Long.valueOf(query.getResultList().size());
		query.setFirstResult((int)pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());
		Page<Usuario> page = new PageImpl<>(query.getResultList(), pageable, size);
		
		return page;
	}

}
