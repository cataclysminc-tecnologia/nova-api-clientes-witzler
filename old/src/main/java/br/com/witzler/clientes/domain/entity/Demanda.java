package br.com.witzler.clientes.domain.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name="web_unidade_demanda2", schema="pc" )
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Demanda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="mes_ref")
	private Date mes_ref;
	
	@Column(name="unidade_id")
	private Integer unidade_id;
	
	@Column(name="c_demanda_fponta")
	private double c_demanda_fponta;
	
	@Column(name="c_demanda_ponta")
	private double c_demanda_ponta;
	
	@Column(name="demanda_fponta")
	private double demanda_fponta;

	@Column(name="demanda_ponta")
	private double demanda_ponta;
}
