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
@Table(name="web_sustentabilidade", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sustentabilidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="co2_evitado_em_ton")
	private double co2_evitado_em_ton;
	
	@Column(name="campos_de_futebol")
	private double campos_de_futebol;
	
	@Column(name="cliente_id")
	private Integer cliente_id;

}
