package br.com.witzler.clientes.domain.dto;

import java.util.Date;

public class MedidasForaPontaDiarioDTO {
	
	private double foraPonta;
	private double ponta;
	private Date data_medicao;
	public double getForaPonta() {
		return foraPonta;
	}
	public void setForaPonta(double foraPonta) {
		this.foraPonta = foraPonta;
	}
	public double getPonta() {
		return ponta;
	}
	public void setPonta(double ponta) {
		this.ponta = ponta;
	}
	public Date getData_medicao() {
		return data_medicao;
	}
	public void setData_medicao(Date data_medicao) {
		this.data_medicao = data_medicao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_medicao == null) ? 0 : data_medicao.hashCode());
		long temp;
		temp = Double.doubleToLongBits(foraPonta);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ponta);
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
		MedidasForaPontaDiarioDTO other = (MedidasForaPontaDiarioDTO) obj;
		if (data_medicao == null) {
			if (other.data_medicao != null)
				return false;
		} else if (!data_medicao.equals(other.data_medicao))
			return false;
		if (Double.doubleToLongBits(foraPonta) != Double.doubleToLongBits(other.foraPonta))
			return false;
		if (Double.doubleToLongBits(ponta) != Double.doubleToLongBits(other.ponta))
			return false;
		return true;
	}
	
	
	
	
	

}
