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
@Table(name="web_rateio", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rateio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_rateio")
	private Integer id_rateio;
	
	@Column(name="cow_unit_id")
	private Integer cow_unit_id;
	
	@Column(name="consumo")
	private double consumo;
	
	@Column(name="consumo_proinfa")
	private double consumo_proinfa;
	
	@Column(name="consumo_contrato")
	private double consumo_contrato;
	
	@Column(name="contrato")
	private double contrato;
	
	@Column(name="sobra_excedente_text")
	private String sobra_excedente_text;
	
	@Column(name="sobra_excedente_valor")
	private double sobra_excedente_valor;
	
	@Column(name="rateio")
	private double rateio;
	
	@Column(name="operacao_realizada_text")
	private String operacao_realizada_text;
	
	@Column(name="operacao_realizada_valor")
	private double operacao_realizada_valor;
	
	@Column(name="liquidacao")
	private double liquidacao;
	
	@Column(name="contract_son_id")
	private Integer contract_son_id;
	
	@Column(name="take")
	private double take;
	
	@Column(name="soma_consumo_proinfa")
	private double soma_consumo_proinfa;
	
	@Column(name="soma_consumo_contrato")
	private double soma_consumo_contrato;
	
	@Column(name="data_referencia")
	private String data_referencia;
	
	@Column(name="flex_sup")
	private double flex_sup;
	
	@Column(name="flex_inf")
	private double flex_inf;
	
	@Column(name="contract_id")
	private Integer contract_id;

}
