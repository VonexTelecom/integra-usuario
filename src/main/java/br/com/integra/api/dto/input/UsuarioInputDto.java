package br.com.integra.api.dto.input;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.integra.api.enums.StatusEnum;
import br.com.integra.api.enums.UsuarioGrupo;
import lombok.Data;

@Data
public class UsuarioInputDto {

	@NotBlank
	private String nome;

	@Email
	@NotBlank
	private String email;
	
	@NotBlank
	private String usuario;
	
	@NotBlank
	private String senha;
	
	private List<UsuarioGrupo> grupos;
	
	private StatusEnum status;
	

}
