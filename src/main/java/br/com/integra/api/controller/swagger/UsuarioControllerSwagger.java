package br.com.integra.api.controller.swagger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.integra.api.dto.input.UsuarioInputDto;
import br.com.integra.api.dto.output.UsuarioOutputDto;
import br.com.integra.api.exception.handler.Problem;
import br.com.integra.api.model.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Controller do usuario")
public interface UsuarioControllerSwagger {


	@ApiOperation(value = "Adiciona um novo usuario", httpMethod = "POST")
	@ApiResponses({
		@ApiResponse(code = 200, response = Usuario.class, message = "Requisição com sucesso")
	})
	ResponseEntity<UsuarioOutputDto> save (@RequestBody @ApiParam(name="body", value = "Representação de um Usuario") UsuarioInputDto user
			, UriComponentsBuilder uri);
	
	@ApiOperation(value = "Atualiza um usuario", httpMethod = "PUT")
	@ApiResponses({
		@ApiResponse(code = 200, response = Usuario.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	ResponseEntity<?> update (@RequestBody @ApiParam(name="body", value = "Representação de um Usuario") UsuarioInputDto user,
			@PathVariable Long id);
	
	@ApiOperation(value = "Deleta um usuario", httpMethod = "DELETE")
	@ApiResponses({
		@ApiResponse(code = 204, response = Usuario.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	ResponseEntity<?> delete(@PathVariable Long id);
	
	@ApiOperation(value = "Ativa um usuario", httpMethod = "PUT")
	@ApiResponses({
		@ApiResponse(code = 204, response = Usuario.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	void ativarUsuario(@PathVariable Long id);
	
	@ApiOperation(value = "Desativa um usuario", httpMethod = "PUT")
	@ApiResponses({
		@ApiResponse(code = 204, response = Usuario.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	void desativarUsuario(@PathVariable Long id);
}
