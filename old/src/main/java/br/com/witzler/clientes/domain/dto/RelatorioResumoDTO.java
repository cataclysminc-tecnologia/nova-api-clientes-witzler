package br.com.witzler.clientes.domain.dto;

import java.util.Date;

import javax.persistence.Column;

import lombok.Data;

@Data
public class RelatorioResumoDTO {
	
	private Integer id;
	private Integer id_unid;
	private Integer id_cliente;
	private Date data_ref;
	private Boolean previa;
	private double custo_efetivo;
	private double consumo;
	private double acl_energia_contrato;
	private double acl_energia_cp;
	private double acl_energia_swap;
	private double acl_fat_dist;
	private double acl_ccee_liq;
	private double acl_ccee_encargo;
	private double acl_imposto;
	private double acr_tusd;
	private double acr_imposto;
	private double acr_outros;
	private double acr_energia;
	

}
