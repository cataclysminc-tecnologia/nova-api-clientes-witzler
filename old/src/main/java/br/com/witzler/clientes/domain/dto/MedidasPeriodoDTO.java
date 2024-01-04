package br.com.witzler.clientes.domain.dto;

import java.util.Date;

public class MedidasPeriodoDTO {
	
	private Integer id_medidas;
	private double ativo_c;
	private double reativo_c;
	private double ativo_g;
	private double reativo_g;
	private Integer dia_da_semana;
	private Date data_medicao;
	private Integer hora_do_dia;
	private Integer unidade_id;
	private Integer tipo_medida;
	private Integer status;
	public Integer getId_medidas() {
		return id_medidas;
	}
	public void setId_medidas(Integer id_medidas) {
		this.id_medidas = id_medidas;
	}
	public double getAtivo_c() {
		return ativo_c;
	}
	public void setAtivo_c(double ativo_c) {
		this.ativo_c = ativo_c;
	}
	public double getReativo_c() {
		return reativo_c;
	}
	public void setReativo_c(double reativo_c) {
		this.reativo_c = reativo_c;
	}
	public double getAtivo_g() {
		return ativo_g;
	}
	public void setAtivo_g(double ativo_g) {
		this.ativo_g = ativo_g;
	}
	public double getReativo_g() {
		return reativo_g;
	}
	public void setReativo_g(double reativo_g) {
		this.reativo_g = reativo_g;
	}
	public Integer getDia_da_semana() {
		return dia_da_semana;
	}
	public void setDia_da_semana(Integer dia_da_semana) {
		this.dia_da_semana = dia_da_semana;
	}
	public Date getData_medicao() {
		return data_medicao;
	}
	public void setData_medicao(Date data_medicao) {
		this.data_medicao = data_medicao;
	}
	public Integer getHora_do_dia() {
		return hora_do_dia;
	}
	public void setHora_do_dia(Integer hora_do_dia) {
		this.hora_do_dia = hora_do_dia;
	}
	public Integer getUnidade_id() {
		return unidade_id;
	}
	public void setUnidade_id(Integer unidade_id) {
		this.unidade_id = unidade_id;
	}
	public Integer getTipo_medida() {
		return tipo_medida;
	}
	public void setTipo_medida(Integer tipo_medida) {
		this.tipo_medida = tipo_medida;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(ativo_c);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ativo_g);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((data_medicao == null) ? 0 : data_medicao.hashCode());
		result = prime * result + ((dia_da_semana == null) ? 0 : dia_da_semana.hashCode());
		result = prime * result + ((hora_do_dia == null) ? 0 : hora_do_dia.hashCode());
		result = prime * result + ((id_medidas == null) ? 0 : id_medidas.hashCode());
		temp = Double.doubleToLongBits(reativo_c);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(reativo_g);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tipo_medida == null) ? 0 : tipo_medida.hashCode());
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
		MedidasPeriodoDTO other = (MedidasPeriodoDTO) obj;
		if (Double.doubleToLongBits(ativo_c) != Double.doubleToLongBits(other.ativo_c))
			return false;
		if (Double.doubleToLongBits(ativo_g) != Double.doubleToLongBits(other.ativo_g))
			return false;
		if (data_medicao == null) {
			if (other.data_medicao != null)
				return false;
		} else if (!data_medicao.equals(other.data_medicao))
			return false;
		if (dia_da_semana == null) {
			if (other.dia_da_semana != null)
				return false;
		} else if (!dia_da_semana.equals(other.dia_da_semana))
			return false;
		if (hora_do_dia == null) {
			if (other.hora_do_dia != null)
				return false;
		} else if (!hora_do_dia.equals(other.hora_do_dia))
			return false;
		if (id_medidas == null) {
			if (other.id_medidas != null)
				return false;
		} else if (!id_medidas.equals(other.id_medidas))
			return false;
		if (Double.doubleToLongBits(reativo_c) != Double.doubleToLongBits(other.reativo_c))
			return false;
		if (Double.doubleToLongBits(reativo_g) != Double.doubleToLongBits(other.reativo_g))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tipo_medida == null) {
			if (other.tipo_medida != null)
				return false;
		} else if (!tipo_medida.equals(other.tipo_medida))
			return false;
		if (unidade_id == null) {
			if (other.unidade_id != null)
				return false;
		} else if (!unidade_id.equals(other.unidade_id))
			return false;
		return true;
	}
	
	
	
	

}
