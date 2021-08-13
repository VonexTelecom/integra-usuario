package br.com.integra.api.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.integra.api.model.Usuario;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@And({ 
	@Spec(path = "status", params = "status", spec = LikeIgnoreCase.class),
	@Spec(path = "tipo", params = "tipo", spec = LikeIgnoreCase.class),
	@Spec(path = "clienteId", params = "clienteId", spec = LikeIgnoreCase.class)
})
public interface UsuarioSpecification extends Specification<Usuario>{}