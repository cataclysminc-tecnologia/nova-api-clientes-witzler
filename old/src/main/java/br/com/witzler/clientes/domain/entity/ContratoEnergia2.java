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
@Table(name="web_contrato_energia2", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContratoEnergia2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="id_distribuidora")
	private Integer id_distribuidora;
	
	@Column(name="id_cliente")
	private Integer id_cliente;
	
	@Column(name="id_montantes")
	private Integer id_montantes;
	
	@Column(name="cow_id_contrato")
	private Integer cow_id_contrato;
	
	@Column(name="ano")
	private Integer ano;
	
	@Column(name="preco")
	private double preco;
	
	@Column(name="flex_max")
	private double flex_max;
	
	@Column(name="flex_min")
	private double flex_min;
	
	@Column(name="e_sazo")
	private Boolean e_sazo;
	
	@Column(name="e_flex")
	private Boolean e_flex;
	
	@Column(name="sazo_max")
	private double sazo_max;
	
	@Column(name="sazo_min")
	private double sazo_min;
	
	@Column(name="p_carga")
	private double p_carga;
	
	@Column(name="n_contract")
	private String n_contract;
	
	@Column(name="v1")
	private double v1;
	
	@Column(name="v2")
	private double v2;
	
	@Column(name="v3")
	private double v3;
	
	@Column(name="v4")
	private double v4;
	
	@Column(name="v5")
	private double v5;
	
	@Column(name="v6")
	private double v6;
	
	@Column(name="v7")
	private double v7;
	
	@Column(name="v8")
	private double v8;
	
	@Column(name="v9")
	private double v9;
	
	@Column(name="v10")
	private double v10;
	
	@Column(name="v11")
	private double v11;
	
	@Column(name="v12")
	private double v12;
	

}
