package br.com.witzler.clientes.domain.dto;

import java.util.Date;

public class PerformanceUnidadesDTO {
	
	private Integer id_performance;
	private Integer unit_cow_id;
	private double valor_economizado;
	private double porcentagem_economia;
	private Date data_referencia;
	
	public Integer getId_performance() {
		return id_performance;
	}
	public void setId_performance(Integer id_performance) {
		this.id_performance = id_performance;
	}
	public Integer getUnit_cow_id() {
		return unit_cow_id;
	}
	public void setUnit_cow_id(Integer unit_cow_id) {
		this.unit_cow_id = unit_cow_id;
	}
	public double getValor_economizado() {
		return valor_economizado;
	}
	public void setValor_economizado(double valor_economizado) {
		this.valor_economizado = valor_economizado;
	}
	public double getPorcentagem_economia() {
		return porcentagem_economia;
	}
	public void setPorcentagem_economia(double porcentagem_economia) {
		this.porcentagem_economia = porcentagem_economia;
	}
	
	public Date getData_referencia() {
		return data_referencia;
	}
	public void setData_referencia(Date data_referencia) {
		this.data_referencia = data_referencia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_referencia == null) ? 0 : data_referencia.hashCode());
		result = prime * result + ((id_performance == null) ? 0 : id_performance.hashCode());
		long temp;
		temp = Double.doubleToLongBits(porcentagem_economia);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((unit_cow_id == null) ? 0 : unit_cow_id.hashCode());
		temp = Double.doubleToLongBits(valor_economizado);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		PerformanceUnidadesDTO other = (PerformanceUnidadesDTO) obj;
		if (data_referencia == null) {
			if (other.data_referencia != null)
				return false;
		} else if (!data_referencia.equals(other.data_referencia))
			return false;
		if (id_performance == null) {
			if (other.id_performance != null)
				return false;
		} else if (!id_performance.equals(other.id_performance))
			return false;
		if (Double.doubleToLongBits(porcentagem_economia) != Double.doubleToLongBits(other.porcentagem_economia))
			return false;
		if (unit_cow_id == null) {
			if (other.unit_cow_id != null)
				return false;
		} else if (!unit_cow_id.equals(other.unit_cow_id))
			return false;
		if (Double.doubleToLongBits(valor_economizado) != Double.doubleToLongBits(other.valor_economizado))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PerformanceUnidadesDTO [id_performance=" + id_performance + ", unit_cow_id=" + unit_cow_id
				+ ", valor_economizado=" + valor_economizado + ", porcentagem_economia=" + porcentagem_economia
				+ ", data_referencia=" + data_referencia + "]";
	}
	
	
	
	
	

}
