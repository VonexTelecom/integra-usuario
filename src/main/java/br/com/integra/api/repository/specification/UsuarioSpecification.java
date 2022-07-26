package br.com.integra.api.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.integra.api.model.Usuario;
import net.kaczmarzyk.spring.data.jpa.domain.In;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@And({ @Spec(path = "status", params = "status", spec = Like.class),
		@Spec(path = "grupo", params = "grupos",spec = In.class)})
public interface UsuarioSpecification extends Specification<Usuario> {

}
