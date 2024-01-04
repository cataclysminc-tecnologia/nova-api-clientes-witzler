package br.com.witzler.clientes.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="web_login", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WebLogin {
	
	@Id
	@Column(name="id_login")
	private Integer id_login;
	
	@Column(name="username")
	private String username;
	
	@Column(name="u_password")
	private String u_password;
	
	@Column(name="admin")
	private Boolean admin;
	
}
