package br.com.integra.api.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.integra.api.enums.UsuarioTipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Usuario")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nome")
	private String nome;

	@Column(name="email")
	private String email;
	
	@Column(name="usuario")
	private String usuario;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="tipo")
	private UsuarioTipo tipo;
	
	@Column(name="ativo")
	private Integer ativo;
	
	@Column(name="dataDeCriacao")
	private Date dataDeCriacao;
	
	//@ManyToOne
	//private Long clientId;

}
