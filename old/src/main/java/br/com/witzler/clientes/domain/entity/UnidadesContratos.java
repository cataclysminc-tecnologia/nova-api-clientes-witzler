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
@Table(name="web_unidades", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UnidadesContratos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_unidades")
	private Integer id_unidades;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="latitude")
	private String latitude;
	
	@Column(name="longitude")
	private String longitude;

	@Column(name="distribuidora")
	private String distribuidora;
	
	@Column(name="cliente_id")
	private Integer cliente_id;
	
	@Column(name="cow_unit_id")
	private Integer cow_unit_id;
	
	@Column(name="medidor")
	private String medidor;
	
	@Column(name="medidor_reserva")
	private String medidor_reserva;
	
	@Column(name="medidor_r_existe")
	private boolean medidor_r_existe;
	
	@Column(name="perfil_agente")
	private Integer perfil_agente;
	
	@Column(name="nome_unidade")
	private String nome_unidade;
	
	@Column(name="comercializadora_id")
	private Integer comercializadora_id;
	
	@Column(name="inicio_suprimento")
	private Date inicio_suprimento;
	
	@Column(name="fim_suprimento")
	private Date fim_suprimento;
	
	@Column(name="montante_percentual")
	private double montante_percentual;
	
	@Column(name="e_sazo")
	private boolean e_sazo;
	
	@Column(name="sazo_inf")
	private double sazo_inf;
	
	@Column(name="sazo_sup")
	private double sazo_sup;
	
	@Column(name="e_flex")
	private boolean e_flex;
	
	@Column(name="flex_inf")
	private double flex_inf;
	
	@Column(name="flex_sup")
	private double flex_sup;

	@Column(name="montante")
	private String montante;

	@Column(name="path")
	private String path;

	@Column(name="numero_contrato")
	private String numero_contrato;

	@Column(name="preco_base")
	private double preco_base;

}
