package br.com.witzler.clientes.domain.dto;

import java.util.Date;

public class PldSemanalDTO {
	
	private Integer id;
	private Date data_inicial;
	private Date data_final;
	private double pesada_se_co;
	private double pesada_s;
	private double pesada_ne;
	private double pesada_n;
	private double media_se_co;
	private double media_s;
	private double media_ne;
	private double media_n;
	private double leve_se_co;
	private double leve_s;
	private double leve_ne;
	private double leve_n;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getData_inicial() {
		return data_inicial;
	}
	public void setData_inicial(Date data_inicial) {
		this.data_inicial = data_inicial;
	}
	public Date getData_final() {
		return data_final;
	}
	public void setData_final(Date data_final) {
		this.data_final = data_final;
	}
	public double getPesada_se_co() {
		return pesada_se_co;
	}
	public void setPesada_se_co(double pesada_se_co) {
		this.pesada_se_co = pesada_se_co;
	}
	public double getPesada_s() {
		return pesada_s;
	}
	public void setPesada_s(double pesada_s) {
		this.pesada_s = pesada_s;
	}
	public double getPesada_ne() {
		return pesada_ne;
	}
	public void setPesada_ne(double pesada_ne) {
		this.pesada_ne = pesada_ne;
	}
	public double getPesada_n() {
		return pesada_n;
	}
	public void setPesada_n(double pesada_n) {
		this.pesada_n = pesada_n;
	}
	public double getMedia_se_co() {
		return media_se_co;
	}
	public void setMedia_se_co(double media_se_co) {
		this.media_se_co = media_se_co;
	}
	public double getMedia_s() {
		return media_s;
	}
	public void setMedia_s(double media_s) {
		this.media_s = media_s;
	}
	public double getMedia_ne() {
		return media_ne;
	}
	public void setMedia_ne(double media_ne) {
		this.media_ne = media_ne;
	}
	public double getMedia_n() {
		return media_n;
	}
	public void setMedia_n(double media_n) {
		this.media_n = media_n;
	}
	public double getLeve_se_co() {
		return leve_se_co;
	}
	public void setLeve_se_co(double leve_se_co) {
		this.leve_se_co = leve_se_co;
	}
	public double getLeve_s() {
		return leve_s;
	}
	public void setLeve_s(double leve_s) {
		this.leve_s = leve_s;
	}
	public double getLeve_ne() {
		return leve_ne;
	}
	public void setLeve_ne(double leve_ne) {
		this.leve_ne = leve_ne;
	}
	public double getLeve_n() {
		return leve_n;
	}
	public void setLeve_n(double leve_n) {
		this.leve_n = leve_n;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_final == null) ? 0 : data_final.hashCode());
		result = prime * result + ((data_inicial == null) ? 0 : data_inicial.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(leve_n);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(leve_ne);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(leve_s);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(leve_se_co);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(media_n);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(media_ne);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(media_s);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(media_se_co);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(pesada_n);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(pesada_ne);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(pesada_s);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(pesada_se_co);
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
		PldSemanalDTO other = (PldSemanalDTO) obj;
		if (data_final == null) {
			if (other.data_final != null)
				return false;
		} else if (!data_final.equals(other.data_final))
			return false;
		if (data_inicial == null) {
			if (other.data_inicial != null)
				return false;
		} else if (!data_inicial.equals(other.data_inicial))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(leve_n) != Double.doubleToLongBits(other.leve_n))
			return false;
		if (Double.doubleToLongBits(leve_ne) != Double.doubleToLongBits(other.leve_ne))
			return false;
		if (Double.doubleToLongBits(leve_s) != Double.doubleToLongBits(other.leve_s))
			return false;
		if (Double.doubleToLongBits(leve_se_co) != Double.doubleToLongBits(other.leve_se_co))
			return false;
		if (Double.doubleToLongBits(media_n) != Double.doubleToLongBits(other.media_n))
			return false;
		if (Double.doubleToLongBits(media_ne) != Double.doubleToLongBits(other.media_ne))
			return false;
		if (Double.doubleToLongBits(media_s) != Double.doubleToLongBits(other.media_s))
			return false;
		if (Double.doubleToLongBits(media_se_co) != Double.doubleToLongBits(other.media_se_co))
			return false;
		if (Double.doubleToLongBits(pesada_n) != Double.doubleToLongBits(other.pesada_n))
			return false;
		if (Double.doubleToLongBits(pesada_ne) != Double.doubleToLongBits(other.pesada_ne))
			return false;
		if (Double.doubleToLongBits(pesada_s) != Double.doubleToLongBits(other.pesada_s))
			return false;
		if (Double.doubleToLongBits(pesada_se_co) != Double.doubleToLongBits(other.pesada_se_co))
			return false;
		return true;
	}
	
	
	
	

}
