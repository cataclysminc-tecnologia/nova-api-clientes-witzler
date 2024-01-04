package br.com.witzler.clientes.domain.dto;

public class MediaFatorPotenciaDTO {
	
	private double capacitivo;
	private double indutivo;
	private double ativo_c;
	private double reativo_c;
	
	public double getCapacitivo() {
		return capacitivo;
	}
	public void setCapacitivo(double capacitivo) {
		this.capacitivo = capacitivo;
	}
	public double getIndutivo() {
		return indutivo;
	}
	public void setIndutivo(double indutivo) {
		this.indutivo = indutivo;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(ativo_c);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(capacitivo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(indutivo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(reativo_c);
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
		MediaFatorPotenciaDTO other = (MediaFatorPotenciaDTO) obj;
		if (Double.doubleToLongBits(ativo_c) != Double.doubleToLongBits(other.ativo_c))
			return false;
		if (Double.doubleToLongBits(capacitivo) != Double.doubleToLongBits(other.capacitivo))
			return false;
		if (Double.doubleToLongBits(indutivo) != Double.doubleToLongBits(other.indutivo))
			return false;
		if (Double.doubleToLongBits(reativo_c) != Double.doubleToLongBits(other.reativo_c))
			return false;
		return true;
	}
	
	
	
	
	

}
