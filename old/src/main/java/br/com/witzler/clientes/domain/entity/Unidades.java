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
@Table(name="web_unidades", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Unidades {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_unidades")
	private Integer id_unidades;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="latitude")
	private String latitude;
	
	@Column(name="longitude")
	private String longitude;

	@Column(name="distribuidora")
	private String distribuidora;
	
	@Column(name="cliente_id")
	private Integer cliente_id;
	
	@Column(name="cow_unit_id")
	private Integer cow_unit_id;
	
	@Column(name="medidor")
	private String medidor;
	
	@Column(name="medidor_reserva")
	private String medidor_reserva;
	
	@Column(name="medidor_r_existe")
	private boolean medidor_r_existe;
	
	@Column(name="perfil_agente")
	private Integer perfil_agente;
	
	@Column(name="uc_unidade")
	private String uc_unidade;

}
