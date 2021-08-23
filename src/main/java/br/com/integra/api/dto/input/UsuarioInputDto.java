package br.com.integra.api.dto.input;

import java.util.List;

import br.com.integra.api.enums.StatusEnum;
import br.com.integra.api.enums.UsuarioGrupo;
import lombok.Data;

@Data
public class UsuarioInputDto {
	
	private String nome;

	private String email;
	
	private String usuario;
	
	private String senha;
	
	private List<UsuarioGrupo> grupos;
	
	private StatusEnum status;
	

}
