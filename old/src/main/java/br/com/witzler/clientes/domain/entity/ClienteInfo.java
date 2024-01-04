package br.com.witzler.clientes.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="web_cliente", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cliente")
	Integer id_cliente;
	
	@Column(name="nome")
	String nome;
	
	@Column(name="email")
	String email;
	
	@Column(name="nome_fantasia")
	String nome_fantasia;
	
	@Column(name="colaborador_tec_id")
	Integer colaborador_tec_id;
	
	@Column(name="colaborador_comercial_id")
	Integer colaborador_comercial_id;
	
	@Column(name="cow_client_id")
	Integer cow_client_id;
	
	@Column(name="type_client")
	Integer type_client;

}
