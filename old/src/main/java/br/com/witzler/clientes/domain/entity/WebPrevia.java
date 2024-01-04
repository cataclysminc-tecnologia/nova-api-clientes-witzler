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
@Table(name="web_previa", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WebPrevia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name="data_previa")
	private Date data_previa;
	
	@Column(name = "max_c")
	private Double max_c;
	
	@Column(name = "min_c")
	private Double min_c;
	
	@Column(name = "contratado")
	private Double contratado;
	
	@Column(name = "consumido")
	private Double consumido;
	
	@Column(name = "unidade_id")
	private Integer unidade_id;
	
	@Column(name = "consumo_medido")
	private Double consumo_medido;

}
