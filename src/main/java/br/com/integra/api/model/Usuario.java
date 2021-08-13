package br.com.integra.api.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import br.com.integra.api.enums.StatusEnum;
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
	
	@Column(name="status")
	private StatusEnum status;
	
	@Column(name="data_criacao")
	@CreationTimestamp
	private Date dataDeCriacao;
	
	@ManyToOne
	@JoinColumn(name = "clienteId", nullable = false)
	private Cliente cliente;

}
