package br.com.integra.api.filter;

import br.com.integra.api.enums.StatusEnum;
import br.com.integra.api.enums.UsuarioGrupo;
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

	@ApiModelProperty(value = "status",name = "status" ,dataType = "Enum", example = "ATIVO")
	private StatusEnum status;
	
	@ApiModelProperty(value = "Tipo do Grupo", name = "grupo", dataType = "Enum", example = "ADMIN")
	private UsuarioGrupo grupo;
}
