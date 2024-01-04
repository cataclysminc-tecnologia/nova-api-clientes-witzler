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
@Table(name="web_distribuidora", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Distribuidora {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_distribuidora")
	private Integer id_distribuidora;
	
	@Column(name="nome_distribuidora")
	private String nome_distribuidora;
	
	@Column(name="descricao_distribuidora")
	private String descricao_distribuidora;

}
