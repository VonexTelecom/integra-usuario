package br.com.integra.api.controller.swagger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.integra.api.dto.input.UsuarioInputDto;
import br.com.integra.api.dto.output.UsuarioOutputDto;
import br.com.integra.api.exception.handler.Problem;
import br.com.integra.api.filter.UsuarioFilter;
import br.com.integra.api.model.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@Api(tags = "Controller do Usuário")
public interface UsuarioControllerSwagger {

	@ApiOperation(value = "Busca um único Usuário", httpMethod = "GET")
	@ApiResponses({
		@ApiResponse(code = 200, response = Usuario.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	ResponseEntity<?>findById(@PathVariable Long id);

	@ApiOperation(value = "Busca todos os Usuários", httpMethod = "GET")
	@ApiResponses({
		@ApiResponse(code = 200, response = Usuario.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 204, response = Usuario.class, message = "Não encontrado")
	})ResponseEntity<Page<UsuarioOutputDto>>findAll(
			@And({ 
		@Spec(path = "status", params = "status", spec = Equal.class),
		@Spec(path = "tipo", params = "tipo", spec = Equal.class),
		@Spec(path = "cliente.id", params = "clienteId", spec = Equal.class)}) Specification<Usuario> spec, Pageable pageable, UsuarioFilter filter);
	
	
	@ApiOperation(value = "Adiciona um novo Usuário", httpMethod = "POST")
	@ApiResponses({
		@ApiResponse(code = 200, response = Usuario.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	ResponseEntity<UsuarioOutputDto> save (@RequestBody @ApiParam(name="body", value = "Representação de um Usuário") UsuarioInputDto user
			, UriComponentsBuilder uri);
	
	@ApiOperation(value = "Atualiza um Usuário", httpMethod = "PUT")
	@ApiResponses({
		@ApiResponse(code = 200, response = Usuario.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	ResponseEntity<?> update (@RequestBody @ApiParam(name="body", value = "Representação de um Usuário") UsuarioInputDto user,
			@PathVariable Long id);
	
	@ApiOperation(value = "Deleta um Usuário", httpMethod = "DELETE")
	@ApiResponses({
		@ApiResponse(code = 204, response = Usuario.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	ResponseEntity<?> delete(@PathVariable Long id);
	
	@ApiOperation(value = "Ativa um Usuário", httpMethod = "PUT")
	@ApiResponses({
		@ApiResponse(code = 204, response = Usuario.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	UsuarioOutputDto ativarUsuario(@PathVariable Long id);
	
	@ApiOperation(value = "Desativa um Usuário", httpMethod = "PUT")
	@ApiResponses({
		@ApiResponse(code = 204, response = Usuario.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	UsuarioOutputDto desativarUsuario(@PathVariable Long id);
}
