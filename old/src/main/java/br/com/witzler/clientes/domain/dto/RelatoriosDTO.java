package br.com.witzler.clientes.domain.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RelatoriosDTO {

	private Integer id_relatorio;
	private String data_referencia; 
	private Integer cow_unit_id;
	private double valor_1;
	private double valor_2;
	private Integer linha;
	private Integer coluna;
	private Integer distribuidora_id;
	private Integer tarifa;
	
	public Integer getId_relatorio() {
		return id_relatorio;
	}
	public void setId_relatorio(Integer id_relatorio) {
		this.id_relatorio = id_relatorio;
	}
	public String getData_referencia() {
		return data_referencia;
	}
	public void setData_referencia(String data_referencia) {
		this.data_referencia = data_referencia;
	}
	public Integer getCow_unit_id() {
		return cow_unit_id;
	}
	public void setCow_unit_id(Integer cow_unit_id) {
		this.cow_unit_id = cow_unit_id;
	}
	public double getValor_1() {
		return valor_1;
	}
	public void setValor_1(double valor_1) {
		this.valor_1 = valor_1;
	}
	public double getValor_2() {
		return valor_2;
	}
	public void setValor_2(double valor_2) {
		this.valor_2 = valor_2;
	}
	public Integer getLinha() {
		return linha;
	}
	public void setLinha(Integer linha) {
		this.linha = linha;
	}
	public Integer getColuna() {
		return coluna;
	}
	public void setColuna(Integer coluna) {
		this.coluna = coluna;
	}
	public Integer getDistribuidora_id() {
		return distribuidora_id;
	}
	public void setDistribuidora_id(Integer distribuidora_id) {
		this.distribuidora_id = distribuidora_id;
	}
	public Integer getTarifa() {
		return tarifa;
	}
	public void setTarifa(Integer tarifa) {
		this.tarifa = tarifa;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coluna == null) ? 0 : coluna.hashCode());
		result = prime * result + ((cow_unit_id == null) ? 0 : cow_unit_id.hashCode());
		result = prime * result + ((data_referencia == null) ? 0 : data_referencia.hashCode());
		result = prime * result + ((distribuidora_id == null) ? 0 : distribuidora_id.hashCode());
		result = prime * result + ((id_relatorio == null) ? 0 : id_relatorio.hashCode());
		result = prime * result + ((linha == null) ? 0 : linha.hashCode());
		result = prime * result + ((tarifa == null) ? 0 : tarifa.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor_1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valor_2);
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
		RelatoriosDTO other = (RelatoriosDTO) obj;
		if (coluna == null) {
			if (other.coluna != null)
				return false;
		} else if (!coluna.equals(other.coluna))
			return false;
		if (cow_unit_id == null) {
			if (other.cow_unit_id != null)
				return false;
		} else if (!cow_unit_id.equals(other.cow_unit_id))
			return false;
		if (data_referencia == null) {
			if (other.data_referencia != null)
				return false;
		} else if (!data_referencia.equals(other.data_referencia))
			return false;
		if (distribuidora_id == null) {
			if (other.distribuidora_id != null)
				return false;
		} else if (!distribuidora_id.equals(other.distribuidora_id))
			return false;
		if (id_relatorio == null) {
			if (other.id_relatorio != null)
				return false;
		} else if (!id_relatorio.equals(other.id_relatorio))
			return false;
		if (linha == null) {
			if (other.linha != null)
				return false;
		} else if (!linha.equals(other.linha))
			return false;
		if (tarifa == null) {
			if (other.tarifa != null)
				return false;
		} else if (!tarifa.equals(other.tarifa))
			return false;
		if (Double.doubleToLongBits(valor_1) != Double.doubleToLongBits(other.valor_1))
			return false;
		if (Double.doubleToLongBits(valor_2) != Double.doubleToLongBits(other.valor_2))
			return false;
		return true;
	}
		

}
