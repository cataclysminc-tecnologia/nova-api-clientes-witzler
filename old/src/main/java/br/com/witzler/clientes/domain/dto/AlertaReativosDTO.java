package br.com.witzler.clientes.domain.dto;

public class AlertaReativosDTO {
	
	private Integer cliente_id;
	private double alertar_com;
	private double intervalo;
	
	public Integer getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}
	public double getAlertar_com() {
		return alertar_com;
	}
	public void setAlertar_com(double alertar_com) {
		this.alertar_com = alertar_com;
	}
	public double getIntervalo() {
		return intervalo;
	}
	public void setIntervalo(double intervalo) {
		this.intervalo = intervalo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(alertar_com);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cliente_id == null) ? 0 : cliente_id.hashCode());
		temp = Double.doubleToLongBits(intervalo);
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
		AlertaReativosDTO other = (AlertaReativosDTO) obj;
		if (Double.doubleToLongBits(alertar_com) != Double.doubleToLongBits(other.alertar_com))
			return false;
		if (cliente_id == null) {
			if (other.cliente_id != null)
				return false;
		} else if (!cliente_id.equals(other.cliente_id))
			return false;
		if (Double.doubleToLongBits(intervalo) != Double.doubleToLongBits(other.intervalo))
			return false;
		return true;
	}
	
}
