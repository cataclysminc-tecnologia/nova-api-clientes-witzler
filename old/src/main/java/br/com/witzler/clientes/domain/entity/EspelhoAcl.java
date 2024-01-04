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
@Table(name="web_espelho_acl", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EspelhoAcl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_espelho")
	private Integer id_espelho;
	
	@Column(name="distribuidora_id")
	private Integer distribuidora_id;
	
	@Column(name="tarifa")
	private Integer tarifa;
	
	@Column(name="tipo_texto")
	private Integer tipo_texto;
	
	@Column(name="linha")
	private Integer linha;
	
	@Column(name="coluna")
	private Integer coluna;
	
	@Column(name="texto_1")
	private String texto_1;
	
	@Column(name="texto_2")
	private String texto_2;

}
