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
public class ClienteAlertaReativoContador {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="cliente_id")
	private Integer cliente_id;
	
	@Column(name="mes_ref")
	private String mes_ref;
	
	@Column(name="contador")
	private Integer contador;
	
	
}
