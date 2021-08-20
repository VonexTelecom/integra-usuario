package br.com.integra.api.filter;

import br.com.integra.api.enums.StatusEnum;
import br.com.integra.api.enums.UsuarioTipo;
import br.com.integra.api.model.Cliente;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "UsuarioFilter")
public class UsuarioFilter {

	@ApiModelProperty(value = "status", dataType = "Enum", example = "ATIVO")
	private StatusEnum status;
	
	@ApiModelProperty(value = "Tipo do Usuário", dataType = "Enum", example = "ADMIN")
	private UsuarioTipo tipo;
	
	@ApiModelProperty(value = "Id do Cliente", dataType = "Long", example = "1234")
	private Long clienteId;
}
