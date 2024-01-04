package br.com.witzler.clientes.domain.dto;

public class MedidasPeriodoAtivoCDTO {
	
	private double ativo_c;

	public double getAtivo_c() {
		return ativo_c;
	}

	public void setAtivo_c(double ativo_c) {
		this.ativo_c = ativo_c;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(ativo_c);
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
		MedidasPeriodoAtivoCDTO other = (MedidasPeriodoAtivoCDTO) obj;
		if (Double.doubleToLongBits(ativo_c) != Double.doubleToLongBits(other.ativo_c))
			return false;
		return true;
	}
	
	

}
