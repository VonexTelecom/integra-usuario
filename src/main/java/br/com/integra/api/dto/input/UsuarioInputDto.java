package br.com.integra.api.dto.input;

import java.util.Date;

import br.com.integra.api.enums.UsuarioTipo;
import lombok.Data;

@Data
public class UsuarioInputDto {

	
	private String nome;

	private String email;
	
	private String usuario;
	
	private String senha;
	
	private UsuarioTipo tipo;
	
	private Integer ativo;
	
	private Date dataDeCriacao;
	

}
