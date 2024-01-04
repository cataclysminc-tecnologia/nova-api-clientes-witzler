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
@Table(name="web_comercializadora", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Comercializadora {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_comercializadora")
	private Integer id_comercializadora;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="path")
	private String path;
	
	@Column(name="cow_id")
	private Integer cow_id;

}
