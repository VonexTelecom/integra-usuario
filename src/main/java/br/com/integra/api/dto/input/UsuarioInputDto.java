package br.com.integra.api.dto.input;

import br.com.integra.api.enums.StatusEnum;
import br.com.integra.api.enums.UsuarioTipo;
import br.com.integra.api.model.Cliente;
import lombok.Data;

@Data
public class UsuarioInputDto {

	
	private String nome;

	private String email;
	
	private String usuario;
	
	private String senha;
	
	private UsuarioTipo tipo;
	
	private StatusEnum status;
	
	private Cliente cliente;

}
