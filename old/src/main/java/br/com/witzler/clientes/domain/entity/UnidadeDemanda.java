package br.com.witzler.clientes.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="web_unidade_demanda", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UnidadeDemanda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="mes_ref")
	private Date mes_ref;
	
	@Column(name="demanda_fora_ponta")
	private double demanda_fora_ponta;
	
	@Column(name="demanda_ponta")
	private double demanda_ponta;
	
	@Column(name="unidade_id")
	private Integer unidade_id;

}
