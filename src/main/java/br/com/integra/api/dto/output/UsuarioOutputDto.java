package br.com.integra.api.dto.output;

import java.util.Date;
import java.util.List;

import br.com.integra.api.enums.StatusEnum;
import br.com.integra.api.enums.UsuarioGrupo;
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
	
	private List<UsuarioGrupo> grupos;
	
	private StatusEnum status;
	
	private Date dataDeCriacao;
	
	private Cliente cliente;
}
