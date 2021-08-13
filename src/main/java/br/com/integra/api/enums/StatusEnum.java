package br.com.integra.api.enums;

public enum StatusEnum {
	
	ATIVO(0),
	INATIVO(1);

	int valor;
	
	StatusEnum(int valor) {
		this.valor = valor;
	}
}
