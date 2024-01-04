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
@Table(name="web_colaborador", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Colaborador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_colaborador")
	private Integer id_colaborador;
	
	@Column(name="nome_colaborador")
	private String nome_colaborador;
	
	@Column(name="email")
	private String email;

	@Column(name="telefone_1")
	private String telefone_1;

	@Column(name="telefone_2")
	private String telefone_2;
	
	@Column(name="path_img")
	private String path_img;
	
}
