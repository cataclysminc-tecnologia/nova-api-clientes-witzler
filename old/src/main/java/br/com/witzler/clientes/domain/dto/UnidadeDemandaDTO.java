package br.com.witzler.clientes.domain.dto;

import java.util.Date;

public class UnidadeDemandaDTO {
	
	private Integer id;
	private Date mes_ref;
	private double demanda_fora_ponta;
	private double demanda_ponta;
	private Integer unidade_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getMes_ref() {
		return mes_ref;
	}
	public void setMes_ref(Date mes_ref) {
		this.mes_ref = mes_ref;
	}
	public double getDemanda_fora_ponta() {
		return demanda_fora_ponta;
	}
	public void setDemanda_fora_ponta(double demanda_fora_ponta) {
		this.demanda_fora_ponta = demanda_fora_ponta;
	}
	public double getDemanda_ponta() {
		return demanda_ponta;
	}
	public void setDemanda_ponta(double demanda_ponta) {
		this.demanda_ponta = demanda_ponta;
	}
	public Integer getUnidade_id() {
		return unidade_id;
	}
	public void setUnidade_id(Integer unidade_id) {
		this.unidade_id = unidade_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(demanda_fora_ponta);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(demanda_ponta);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mes_ref == null) ? 0 : mes_ref.hashCode());
		result = prime * result + ((unidade_id == null) ? 0 : unidade_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadeDemandaDTO other = (UnidadeDemandaDTO) obj;
		if (Double.doubleToLongBits(demanda_fora_ponta) != Double.doubleToLongBits(other.demanda_fora_ponta))
			return false;
		if (Double.doubleToLongBits(demanda_ponta) != Double.doubleToLongBits(other.demanda_ponta))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mes_ref == null) {
			if (other.mes_ref != null)
				return false;
		} else if (!mes_ref.equals(other.mes_ref))
			return false;
		if (unidade_id == null) {
			if (other.unidade_id != null)
				return false;
		} else if (!unidade_id.equals(other.unidade_id))
			return false;
		return true;
	}
	
	
	
	


}
