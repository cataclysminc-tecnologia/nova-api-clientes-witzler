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
@Table(name="web_relatorio", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Relatorios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_relatorio")
	private Integer id_relatorio;
	
	@Column(name="data_referencia")
	private String data_referencia; //data
	
	@Column(name="cow_unit_id")
	private Integer cow_unit_id;
	
	@Column(name="valor_1")
	private double valor_1;
	
	@Column(name="valor_2")
	private double valor_2;
	
	@Column(name="linha")
	private Integer linha;
	
	@Column(name="coluna")
	private Integer coluna;
	
	@Column(name="distribuidora_id")
	private Integer distribuidora_id;
	
	@Column(name="tarifa")
	private Integer tarifa; 
	
}
