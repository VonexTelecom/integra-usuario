package br.com.integra.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
	
	INATIVO(0),
	ATIVO(1);
	

	int valor;
}
