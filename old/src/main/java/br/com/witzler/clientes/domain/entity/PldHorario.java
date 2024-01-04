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
@Table(name="web_pld_horario2", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PldHorario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="value")
	private double value;
	
	@Column(name="date_ref")
	private Date date_ref;
	
	@Column(name="hour")
	private Integer hour;
	
	@Column(name="date_updated")
	private Date date_updated;
	
	@Column(name="region")
	private Integer region;
	
	

}
