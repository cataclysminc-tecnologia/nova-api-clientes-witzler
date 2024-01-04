package br.com.witzler.clientes.domain.dto;

import java.util.Date;

import javax.persistence.Column;

public class PldHorarioDTO {
	
	private Integer id;
	private double value;
	private Date date_ref;
	private Integer hour;
	private Date date_updated;
	private Integer region;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public Date getDate_ref() {
		return date_ref;
	}
	public void setDate_ref(Date date_ref) {
		this.date_ref = date_ref;
	}
	public Integer getHour() {
		return hour;
	}
	public void setHour(Integer hour) {
		this.hour = hour;
	}
	public Date getDate_updated() {
		return date_updated;
	}
	public void setDate_updated(Date date_updated) {
		this.date_updated = date_updated;
	}
	public Integer getRegion() {
		return region;
	}
	public void setRegion(Integer region) {
		this.region = region;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_ref == null) ? 0 : date_ref.hashCode());
		result = prime * result + ((date_updated == null) ? 0 : date_updated.hashCode());
		result = prime * result + ((hour == null) ? 0 : hour.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
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
		PldHorarioDTO other = (PldHorarioDTO) obj;
		if (date_ref == null) {
			if (other.date_ref != null)
				return false;
		} else if (!date_ref.equals(other.date_ref))
			return false;
		if (date_updated == null) {
			if (other.date_updated != null)
				return false;
		} else if (!date_updated.equals(other.date_updated))
			return false;
		if (hour == null) {
			if (other.hour != null)
				return false;
		} else if (!hour.equals(other.hour))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PldHorarioDTO [id=" + id + ", value=" + value + ", date_ref=" + date_ref + ", hour=" + hour
				+ ", date_updated=" + date_updated + ", region=" + region + "]";
	}

	

}
