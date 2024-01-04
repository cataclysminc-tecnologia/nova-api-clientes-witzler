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
@Table(name="web_performance_unidades", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PerformanceUnidades {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_performance")
	private Integer id_performance;
	
	@Column(name="unit_cow_id")
	private Integer unit_cow_id;
	
	@Column(name="data_referencia")
	private String data_referencia;
	
	@Column(name="valor_economizado")
	private double valor_economizado;
	
	@Column(name="porcentagem_economia")
	private double porcentagem_economia;
	
}
