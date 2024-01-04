package br.com.witzler.clientes.domain.entity;

import java.util.Date;

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
@Table(name="web_pld_semanal", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PldSemanal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="data_inicial")
	private Date data_inicial;
	
	@Column(name="data_final")
	private Date data_final;
	
	@Column(name="pesada_se_co")
	private double pesada_se_co;
	
	@Column(name="pesada_s")
	private double pesada_s;
	
	@Column(name="pesada_ne")
	private double pesada_ne;
	
	@Column(name="pesada_n")
	private double pesada_n;
	
	@Column(name="media_se_co")
	private double media_se_co;
	
	@Column(name="media_s")
	private double media_s;
	
	@Column(name="media_ne")
	private double media_ne;
	
	@Column(name="media_n")
	private double media_n;
	
	@Column(name="leve_se_co")
	private double leve_se_co;
	
	@Column(name="leve_s")
	private double leve_s;
	
	@Column(name="leve_ne")
	private double leve_ne;
	
	@Column(name="leve_n")
	private double leve_n;
	
}
