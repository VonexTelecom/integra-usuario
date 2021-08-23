package br.com.integra.api.enums;


public enum UsuarioGrupo {
	
	NORMAL(0),
	ADMIN(1),
	MASTER(2);

	int valor;
	
	UsuarioGrupo(int valor) {
		this.valor = valor;
	}
}
