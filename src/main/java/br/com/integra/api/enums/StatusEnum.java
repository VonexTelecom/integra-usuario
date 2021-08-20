package br.com.integra.api.enums;

public enum StatusEnum {
	
	INATIVO(0),
	ATIVO(1);
	

	int valor;
	
	StatusEnum(int valor) {
		this.valor = valor;
	}
}
