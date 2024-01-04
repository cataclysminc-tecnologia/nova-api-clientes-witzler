package br.com.witzler.clientes.domain.dto;

import java.util.Date;

public class DemandaDTO {
	private Date mes_ref;
	private double c_demanda_fponta;
	private double c_demanda_ponta;
	private double demanda_fponta;
	private double demanda_ponta;
	
	public Date getMes_ref() {
		return mes_ref;
	}
	
	public void setMes_ref(Date mes_ref) {
		this.mes_ref = mes_ref;
	}
	
	public double getC_demanda_fponta() {
		return c_demanda_fponta;
	}
	
	public void setC_demanda_fponta(double c_demanda_fponta) {
		this.c_demanda_fponta = c_demanda_fponta;
	}
	
	public double getC_demanda_ponta() {
		return c_demanda_ponta;
	}
	
	public void setC_demanda_ponta(double c_demanda_ponta) {
		this.c_demanda_ponta = c_demanda_ponta;
	}
	
	public double getDemanda_fponta() {
		return demanda_fponta;
	}
	
	public void setDemanda_fponta(double demanda_fponta) {
		this.demanda_fponta = demanda_fponta;
	}
	
	public double getDemanda_ponta() {
		return demanda_ponta;
	}
	
	public void setDemanda_ponta(double demanda_ponta) {
		this.demanda_ponta = demanda_ponta;
	}	
}
