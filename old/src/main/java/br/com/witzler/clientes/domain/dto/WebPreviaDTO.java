package br.com.witzler.clientes.domain.dto;

import java.util.Date;

public class WebPreviaDTO {
	
	private Integer id;
	private Date data_previa;
	private Double max_c;
	private Double min_c;
	private Double contratado;
	private Double consumido;
	private Integer unidade_id;
	private Double consumo_medido;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getData_previa() {
		return data_previa;
	}
	public void setData_previa(Date data_previa) {
		this.data_previa = data_previa;
	}
	public Double getMax_c() {
		return max_c;
	}
	public void setMax_c(Double max_c) {
		this.max_c = max_c;
	}
	public Double getMin_c() {
		return min_c;
	}
	public void setMin_c(Double min_c) {
		this.min_c = min_c;
	}
	public Double getContratado() {
		return contratado;
	}
	public void setContratado(Double contratado) {
		this.contratado = contratado;
	}
	public Double getConsumido() {
		return consumido;
	}
	public void setConsumido(Double consumido) {
		this.consumido = consumido;
	}
	public Integer getUnidade_id() {
		return unidade_id;
	}
	public void setUnidade_id(Integer unidade_id) {
		this.unidade_id = unidade_id;
	}
	public Double getConsumo_medido() {
		return consumo_medido;
	}
	public void setConsumo_medido(Double consumo_medido) {
		this.consumo_medido = consumo_medido;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consumido == null) ? 0 : consumido.hashCode());
		result = prime * result + ((consumo_medido == null) ? 0 : consumo_medido.hashCode());
		result = prime * result + ((contratado == null) ? 0 : contratado.hashCode());
		result = prime * result + ((data_previa == null) ? 0 : data_previa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((max_c == null) ? 0 : max_c.hashCode());
		result = prime * result + ((min_c == null) ? 0 : min_c.hashCode());
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
		WebPreviaDTO other = (WebPreviaDTO) obj;
		if (consumido == null) {
			if (other.consumido != null)
				return false;
		} else if (!consumido.equals(other.consumido))
			return false;
		if (consumo_medido == null) {
			if (other.consumo_medido != null)
				return false;
		} else if (!consumo_medido.equals(other.consumo_medido))
			return false;
		if (contratado == null) {
			if (other.contratado != null)
				return false;
		} else if (!contratado.equals(other.contratado))
			return false;
		if (data_previa == null) {
			if (other.data_previa != null)
				return false;
		} else if (!data_previa.equals(other.data_previa))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (max_c == null) {
			if (other.max_c != null)
				return false;
		} else if (!max_c.equals(other.max_c))
			return false;
		if (min_c == null) {
			if (other.min_c != null)
				return false;
		} else if (!min_c.equals(other.min_c))
			return false;
		if (unidade_id == null) {
			if (other.unidade_id != null)
				return false;
		} else if (!unidade_id.equals(other.unidade_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "WebPreviaDTO [id=" + id + ", data_previa=" + data_previa + ", max_c=" + max_c + ", min_c=" + min_c
				+ ", contratado=" + contratado + ", consumido=" + consumido + ", unidade_id=" + unidade_id
				+ ", consumo_medido=" + consumo_medido + "]";
	}
	
	
	
	
	

}
