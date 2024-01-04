package br.com.witzler.clientes.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import br.com.witzler.clientes.validation.NotEmptyList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="web_login2", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {
	
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
	
	private boolean admin; 

}
