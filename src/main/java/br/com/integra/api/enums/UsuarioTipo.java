package br.com.integra.api.enums;

public enum UsuarioTipo {
	
	NORMAL(0),
	ADMIN(1),
	MASTER(2);

	int valor;
	
	UsuarioTipo(int valor) {
		this.valor = valor;
	}
}
