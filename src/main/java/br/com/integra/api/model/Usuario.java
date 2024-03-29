package br.com.integra.api.model;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import br.com.integra.api.enums.StatusEnum;
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
	
	@Column(name="status")
	@Enumerated(EnumType.ORDINAL)
	private StatusEnum status;
	
	@Column(name="data_criacao")
	@CreationTimestamp
	private Date dataDeCriacao;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Usuario_Grupo", 
	  joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"), 
	  inverseJoinColumns = @JoinColumn(name = "grupo_id", referencedColumnName = "id"))
	private List<Grupo> grupos;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false, referencedColumnName = "id")
	private Cliente cliente;
	
	private LocalDateTime ultimoLogin;

}
