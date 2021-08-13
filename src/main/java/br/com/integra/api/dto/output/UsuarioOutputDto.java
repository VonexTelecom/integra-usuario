package br.com.integra.api.dto.output;

import java.util.Date;

import br.com.integra.api.enums.StatusEnum;
import br.com.integra.api.enums.UsuarioTipo;
import br.com.integra.api.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioOutputDto {
	
	private Long id;
	
	private String nome;

	private String email;
	
	private String usuario;
	
	private String senha;
	
	private UsuarioTipo tipo;
	
	private StatusEnum status;
	
	private Date dataDeCriacao;
	
	private Cliente cliente;
}
