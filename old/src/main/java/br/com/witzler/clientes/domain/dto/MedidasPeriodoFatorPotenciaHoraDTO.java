package br.com.witzler.clientes.domain.dto;

public class MedidasPeriodoFatorPotenciaHoraDTO {
	
	private double capacitivo;
	private Integer hora_do_dia;
	
	public double getCapacitivo() {
		return capacitivo;
	}
	public void setCapacitivo(double capacitivo) {
		this.capacitivo = capacitivo;
	}
	public Integer getHora_do_dia() {
		return hora_do_dia;
	}
	public void setHora_do_dia(Integer hora_do_dia) {
		this.hora_do_dia = hora_do_dia;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(capacitivo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((hora_do_dia == null) ? 0 : hora_do_dia.hashCode());
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
		MedidasPeriodoFatorPotenciaHoraDTO other = (MedidasPeriodoFatorPotenciaHoraDTO) obj;
		if (Double.doubleToLongBits(capacitivo) != Double.doubleToLongBits(other.capacitivo))
			return false;
		if (hora_do_dia == null) {
			if (other.hora_do_dia != null)
				return false;
		} else if (!hora_do_dia.equals(other.hora_do_dia))
			return false;
		return true;
	}
	
	
	
	

}
