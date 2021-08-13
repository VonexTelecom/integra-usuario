package br.com.integra.api.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.integra.api.model.Usuario;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@And({ 
	@Spec(path = "status", params = "status", spec = Equal.class),
	@Spec(path = "tipo", params = "tipo", spec = Equal.class),
	@Spec(path = "cliente_id", params = "clienteId", spec = Equal.class)
})
public interface UsuarioSpecification extends Specification<Usuario>{}