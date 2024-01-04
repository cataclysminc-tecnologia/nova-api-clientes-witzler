package br.com.witzler.clientes.domain.dto;

public class SustentabilidadeDTO {
	
	private Integer id;
	private double co2_evitado_em_ton;
	private double campos_de_futebol;
	private Integer cliente_id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getCo2_evitado_em_ton() {
		return co2_evitado_em_ton;
	}
	public void setCo2_evitado_em_ton(double co2_evitado_em_ton) {
		this.co2_evitado_em_ton = co2_evitado_em_ton;
	}
	public double getCampos_de_futebol() {
		return campos_de_futebol;
	}
	public void setCampos_de_futebol(double campos_de_futebol) {
		this.campos_de_futebol = campos_de_futebol;
	}
	public Integer getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(campos_de_futebol);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cliente_id == null) ? 0 : cliente_id.hashCode());
		temp = Double.doubleToLongBits(co2_evitado_em_ton);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		SustentabilidadeDTO other = (SustentabilidadeDTO) obj;
		if (Double.doubleToLongBits(campos_de_futebol) != Double.doubleToLongBits(other.campos_de_futebol))
			return false;
		if (cliente_id == null) {
			if (other.cliente_id != null)
				return false;
		} else if (!cliente_id.equals(other.cliente_id))
			return false;
		if (Double.doubleToLongBits(co2_evitado_em_ton) != Double.doubleToLongBits(other.co2_evitado_em_ton))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SustentabilidadeDTO [id=" + id + ", co2_evitado_em_ton=" + co2_evitado_em_ton + ", campos_de_futebol="
				+ campos_de_futebol + ", cliente_id=" + cliente_id + "]";
	}
	
	

}
