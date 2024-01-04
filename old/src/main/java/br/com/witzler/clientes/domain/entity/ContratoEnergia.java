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
@Table(name="web_contrato_energia", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContratoEnergia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_contrato_energia")
	private Integer id_contrato_energia;
	
	@Column(name="comercializadora_id")
	private Integer comercializadora_id;
	
	@Column(name="inicio_suprimento")
	private String inicio_suprimento;
	
	@Column(name="fim_suprimento")
	private String fim_suprimento;
	
	@Column(name="montante_percentual")
	private double montante_percentual;
	
	@Column(name="e_sazo")
	private boolean e_sazo;
	
	@Column(name="sazo_inf")
	private double sazo_inf;
	
	@Column(name="sazo_sup")
	private double sazo_sup;
	
	@Column(name="e_flex")
	private boolean e_flex;
	
	@Column(name="flex_inf")
	private double flex_inf;
	
	@Column(name="flex_sup")
	private double flex_sup;
	
	@Column(name="cow_contract_son_id")
	private Integer cow_contract_son_id;
	
	@Column(name="montante")
	private String montante;
	
	@Column(name="preco_base")
	private double preco_base;
	
	@Column(name="numero_contrato")
	private String numero_contrato;
	
}
