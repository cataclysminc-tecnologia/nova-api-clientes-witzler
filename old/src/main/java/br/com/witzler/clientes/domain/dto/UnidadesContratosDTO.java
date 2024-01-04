package br.com.witzler.clientes.domain.dto;

import java.util.Date;

public class UnidadesContratosDTO {
	
	private String nome_unidade;
	private Integer comercializadora_id;
	private Date inicio_suprimento;
	private Date fim_suprimento;
	private double montante_percentual;
	private boolean e_sazo;
	private double sazo_inf;
	private double sazo_sup;
	private boolean e_flex;
	private double flex_inf;
	private double flex_sup;
	private String montante;
	private String nome;
	private String path;
	private String numero_contrato;
	private double preco_base;
	public String getNome_unidade() {
		return nome_unidade;
	}
	public void setNome_unidade(String nome_unidade) {
		this.nome_unidade = nome_unidade;
	}
	public Integer getComercializadora_id() {
		return comercializadora_id;
	}
	public void setComercializadora_id(Integer comercializadora_id) {
		this.comercializadora_id = comercializadora_id;
	}
	public Date getInicio_suprimento() {
		return inicio_suprimento;
	}
	public void setInicio_suprimento(Date inicio_suprimento) {
		this.inicio_suprimento = inicio_suprimento;
	}
	public Date getFim_suprimento() {
		return fim_suprimento;
	}
	public void setFim_suprimento(Date fim_suprimento) {
		this.fim_suprimento = fim_suprimento;
	}
	public double getMontante_percentual() {
		return montante_percentual;
	}
	public void setMontante_percentual(double montante_percentual) {
		this.montante_percentual = montante_percentual;
	}
	public boolean isE_sazo() {
		return e_sazo;
	}
	public void setE_sazo(boolean e_sazo) {
		this.e_sazo = e_sazo;
	}
	public double getSazo_inf() {
		return sazo_inf;
	}
	public void setSazo_inf(double sazo_inf) {
		this.sazo_inf = sazo_inf;
	}
	public double getSazo_sup() {
		return sazo_sup;
	}
	public void setSazo_sup(double sazo_sup) {
		this.sazo_sup = sazo_sup;
	}
	public boolean isE_flex() {
		return e_flex;
	}
	public void setE_flex(boolean e_flex) {
		this.e_flex = e_flex;
	}
	public double getFlex_inf() {
		return flex_inf;
	}
	public void setFlex_inf(double flex_inf) {
		this.flex_inf = flex_inf;
	}
	public double getFlex_sup() {
		return flex_sup;
	}
	public void setFlex_sup(double flex_sup) {
		this.flex_sup = flex_sup;
	}
	public String getMontante() {
		return montante;
	}
	public void setMontante(String montante) {
		this.montante = montante;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getNumero_contrato() {
		return numero_contrato;
	}
	public void setNumero_contrato(String numero_contrato) {
		this.numero_contrato = numero_contrato;
	}
	public double getPreco_base() {
		return preco_base;
	}
	public void setPreco_base(double preco_base) {
		this.preco_base = preco_base;
	}
	
	
	
	
	
}
