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
@Table(name="web_contrato_unidade", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContratoUnidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_contrato_energia_unidade")
	private Integer id_contrato_energia_unidade;
	
	@Column(name="cow_contract_son")
	private Integer cow_contract_son;
	
	@Column(name="cow_unit")
	private Integer cow_unit;
	
}
