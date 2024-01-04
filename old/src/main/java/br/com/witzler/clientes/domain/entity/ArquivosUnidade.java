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
@Table(name="web_arquivos_unidade", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArquivosUnidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="data_processado")
	private Date data_processado;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="data_referencia")
	private Date data_referencia;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="data_feito")
	private Date data_feito;
	
	@Column(name="cow_unit_id")
	private Integer cow_unit;
	
	@Column(name="tipo_arquivo")
	private Integer tipo_arquivo;
	
	@Column(name="caminho")
	private String caminho;
	
	@Column(name="tipo_arquivo_descricao")
	private String tipo_arquivo_descricao;

}
