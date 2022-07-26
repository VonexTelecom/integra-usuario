package br.com.integra.api.enums;

import lombok.Getter;

@Getter
public enum UsuarioGrupo {
	
	NORMAL(1),
	ADMIN(2),
	MASTER(3);

	int valor;
	
	UsuarioGrupo(int valor) {
		this.valor = valor;
	}
}
