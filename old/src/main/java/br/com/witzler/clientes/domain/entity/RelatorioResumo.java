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
@Table(name="web_relatorio_resumo", schema="pc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RelatorioResumo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="id_unid")
	private Integer id_unid;
	
	@Column(name="id_cliente")
	private Integer id_cliente;
	
	@Column(name="data_ref")
	private Date data_ref;
	
	@Column(name="previa")
	private Boolean previa;
	
	@Column(name="custo_efetivo")
	private double custo_efetivo;
	
	@Column(name="consumo")
	private double consumo;
	
	@Column(name="acl_energia_contrato")
	private double acl_energia_contrato;
	
	@Column(name="acl_energia_cp")
	private double acl_energia_cp;
	
	@Column(name="acl_energia_swap")
	private double acl_energia_swap;
	
	@Column(name="acl_fat_dist")
	private double acl_fat_dist;
	
	@Column(name="acl_ccee_liq")
	private double acl_ccee_liq;
	
	@Column(name="acl_ccee_encargo")
	private double acl_ccee_encargo;
	
	@Column(name="acl_imposto")
	private double acl_imposto;
	
	@Column(name="acr_tusd")
	private double acr_tusd;
	
	@Column(name="acr_imposto")
	private double acr_imposto;
	
	@Column(name="acr_outros")
	private double acr_outros;
	
	@Column(name="acr_energia")
	private double acr_energia;

}
