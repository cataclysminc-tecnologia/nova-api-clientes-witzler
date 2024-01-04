package br.com.witzler.clientes.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="web_login2", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WebCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private Integer id_cliente;
	
	@Column(name="nome")
	//@NotEmptyList(message="Campo username é obrigatório")
	private String nome;
	
	@Column(name="email")
	//@NotEmptyList(message="Campo senha é obrigatório")
	private String email;
	
	@Column(name="username")
	private String username;
	
	@Column(name="nome_fantasia")
	//@NotEmptyList(message="Campo username é obrigatório")
	private String nome_fantasia;
	
	@Column(name="colaborador_tec_id")
	//@NotEmptyList(message="Campo username é obrigatório")
	private Integer colaborador_tec_id;
	
	@Column(name="colaborador_comercial_id")
	//@NotEmptyList(message="Campo username é obrigatório")
	private Integer colaborador_comercial_id;
	
	@Column(name="cow_client_id")
	//@NotEmptyList(message="Campo username é obrigatório")
	private Integer cow_client_id;
	
	@Column(name="email_recp")
	//@NotEmptyList(message="Campo senha é obrigatório")
	private String email_recp;

}
