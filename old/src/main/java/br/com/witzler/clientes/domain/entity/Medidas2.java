package br.com.witzler.clientes.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="web_listar_medidas", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Medidas2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_medidas")
	private Integer id_medidas;
	
	@Column(name="ativo_c")
	private double ativo_c;
	
	@Column(name="reativo_c")
	private double reativo_c;
	
	@Column(name="ativo_g")
	private double ativo_g;
	
	@Column(name="reativo_g")
	private double reativo_g;
	
	@Column(name="dia_da_semana")
	private Integer dia_da_semana;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name="data_medicao")
	private Date data_medicao;
	
	@Column(name="hora_do_dia")
	private Integer hora_do_dia;
	
	@Column(name="unidade_id")
	private Integer unidade_id;
	
	@Column(name="tipo_medida")
	private Integer tipo_medida;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="capacitivo")
	private double capacitivo;

}
