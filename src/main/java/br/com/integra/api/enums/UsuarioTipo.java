package br.com.integra.api.enums;

public enum UsuarioTipo {
	NORMAL(1),
	ADMIN(2),
	MASTER(3);

	int valorTipo;
	UsuarioTipo(int valor) {
	valorTipo = valor;
	}
}
