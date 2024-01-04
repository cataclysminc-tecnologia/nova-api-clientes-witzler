package br.com.witzler.clientes.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="web_login", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_login")
	private Integer id_login;
	
	@Column(name="username")
	@NotEmpty(message="{campo.username.obrigatorio}")
	//@NotEmptyList(message="Campo username é obrigatório")
	private String username;
	
	@Column(name="u_password")
	@NotEmpty(message="{campo.senha.obrigatorio}")
	//@NotEmptyList(message="Campo senha é obrigatório")
	private String u_password;
	
	@Column
	private boolean admin; 

}
