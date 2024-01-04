package br.com.witzler.clientes.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="web_login_cliente", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WebLoginCliente {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="client_id")
	private Integer client_id;
	
	@Column(name="login_id")
	private Integer login_id;
	
}
