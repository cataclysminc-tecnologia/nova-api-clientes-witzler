package br.com.witzler.clientes.domain.dto;

public class ContratoEnergia2DTO {

	private Integer id;
	private Integer id_distribuidora;
	private Integer id_cliente;
	private Integer id_montantes;
	private Integer cow_id_contrato;
	private Integer ano;
	private double preco;
	private double flex_max;
	private double flex_min;
	private Boolean e_sazo;
	private Boolean e_flex;
	private double sazo_max;
	private double sazo_min;
	private double p_carga;
	private String n_contract;
	private double v1;
	private double v2;
	private double v3;
	private double v4;
	private double v5;
	private double v6;
	private double v7;
	private double v8;
	private double v9;
	private double v10;
	private double v11;
	private double v12;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_distribuidora() {
		return id_distribuidora;
	}
	public void setId_distribuidora(Integer id_distribuidora) {
		this.id_distribuidora = id_distribuidora;
	}
	public Integer getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}
	public Integer getId_montantes() {
		return id_montantes;
	}
	public void setId_montantes(Integer id_montantes) {
		this.id_montantes = id_montantes;
	}
	public Integer getCow_id_contrato() {
		return cow_id_contrato;
	}
	public void setCow_id_contrato(Integer cow_id_contrato) {
		this.cow_id_contrato = cow_id_contrato;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public double getFlex_max() {
		return flex_max;
	}
	public void setFlex_max(double flex_max) {
		this.flex_max = flex_max;
	}
	public double getFlex_min() {
		return flex_min;
	}
	public void setFlex_min(double flex_min) {
		this.flex_min = flex_min;
	}
	public Boolean getE_sazo() {
		return e_sazo;
	}
	public void setE_sazo(Boolean e_sazo) {
		this.e_sazo = e_sazo;
	}
	public Boolean getE_flex() {
		return e_flex;
	}
	public void setE_flex(Boolean e_flex) {
		this.e_flex = e_flex;
	}
	public double getSazo_max() {
		return sazo_max;
	}
	public void setSazo_max(double sazo_max) {
		this.sazo_max = sazo_max;
	}
	public double getSazo_min() {
		return sazo_min;
	}
	public void setSazo_min(double sazo_min) {
		this.sazo_min = sazo_min;
	}
	public double getP_carga() {
		return p_carga;
	}
	public void setP_carga(double p_carga) {
		this.p_carga = p_carga;
	}
	public String getN_contract() {
		return n_contract;
	}
	public void setN_contract(String n_contract) {
		this.n_contract = n_contract;
	}
	public double getV1() {
		return v1;
	}
	public void setV1(double v1) {
		this.v1 = v1;
	}
	public double getV2() {
		return v2;
	}
	public void setV2(double v2) {
		this.v2 = v2;
	}
	public double getV3() {
		return v3;
	}
	public void setV3(double v3) {
		this.v3 = v3;
	}
	public double getV4() {
		return v4;
	}
	public void setV4(double v4) {
		this.v4 = v4;
	}
	public double getV5() {
		return v5;
	}
	public void setV5(double v5) {
		this.v5 = v5;
	}
	public double getV6() {
		return v6;
	}
	public void setV6(double v6) {
		this.v6 = v6;
	}
	public double getV7() {
		return v7;
	}
	public void setV7(double v7) {
		this.v7 = v7;
	}
	public double getV8() {
		return v8;
	}
	public void setV8(double v8) {
		this.v8 = v8;
	}
	public double getV9() {
		return v9;
	}
	public void setV9(double v9) {
		this.v9 = v9;
	}
	public double getV10() {
		return v10;
	}
	public void setV10(double v10) {
		this.v10 = v10;
	}
	public double getV11() {
		return v11;
	}
	public void setV11(double v11) {
		this.v11 = v11;
	}
	public double getV12() {
		return v12;
	}
	public void setV12(double v12) {
		this.v12 = v12;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((cow_id_contrato == null) ? 0 : cow_id_contrato.hashCode());
		result = prime * result + ((e_flex == null) ? 0 : e_flex.hashCode());
		result = prime * result + ((e_sazo == null) ? 0 : e_sazo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(flex_max);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(flex_min);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_cliente == null) ? 0 : id_cliente.hashCode());
		result = prime * result + ((id_distribuidora == null) ? 0 : id_distribuidora.hashCode());
		result = prime * result + ((id_montantes == null) ? 0 : id_montantes.hashCode());
		result = prime * result + ((n_contract == null) ? 0 : n_contract.hashCode());
		temp = Double.doubleToLongBits(p_carga);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sazo_max);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sazo_min);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(v1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(v10);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(v11);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(v12);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(v2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(v3);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(v4);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(v5);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(v6);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(v7);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(v8);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(v9);
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
		ContratoEnergia2DTO other = (ContratoEnergia2DTO) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (cow_id_contrato == null) {
			if (other.cow_id_contrato != null)
				return false;
		} else if (!cow_id_contrato.equals(other.cow_id_contrato))
			return false;
		if (e_flex == null) {
			if (other.e_flex != null)
				return false;
		} else if (!e_flex.equals(other.e_flex))
			return false;
		if (e_sazo == null) {
			if (other.e_sazo != null)
				return false;
		} else if (!e_sazo.equals(other.e_sazo))
			return false;
		if (Double.doubleToLongBits(flex_max) != Double.doubleToLongBits(other.flex_max))
			return false;
		if (Double.doubleToLongBits(flex_min) != Double.doubleToLongBits(other.flex_min))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_cliente == null) {
			if (other.id_cliente != null)
				return false;
		} else if (!id_cliente.equals(other.id_cliente))
			return false;
		if (id_distribuidora == null) {
			if (other.id_distribuidora != null)
				return false;
		} else if (!id_distribuidora.equals(other.id_distribuidora))
			return false;
		if (id_montantes == null) {
			if (other.id_montantes != null)
				return false;
		} else if (!id_montantes.equals(other.id_montantes))
			return false;
		if (n_contract == null) {
			if (other.n_contract != null)
				return false;
		} else if (!n_contract.equals(other.n_contract))
			return false;
		if (Double.doubleToLongBits(p_carga) != Double.doubleToLongBits(other.p_carga))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (Double.doubleToLongBits(sazo_max) != Double.doubleToLongBits(other.sazo_max))
			return false;
		if (Double.doubleToLongBits(sazo_min) != Double.doubleToLongBits(other.sazo_min))
			return false;
		if (Double.doubleToLongBits(v1) != Double.doubleToLongBits(other.v1))
			return false;
		if (Double.doubleToLongBits(v10) != Double.doubleToLongBits(other.v10))
			return false;
		if (Double.doubleToLongBits(v11) != Double.doubleToLongBits(other.v11))
			return false;
		if (Double.doubleToLongBits(v12) != Double.doubleToLongBits(other.v12))
			return false;
		if (Double.doubleToLongBits(v2) != Double.doubleToLongBits(other.v2))
			return false;
		if (Double.doubleToLongBits(v3) != Double.doubleToLongBits(other.v3))
			return false;
		if (Double.doubleToLongBits(v4) != Double.doubleToLongBits(other.v4))
			return false;
		if (Double.doubleToLongBits(v5) != Double.doubleToLongBits(other.v5))
			return false;
		if (Double.doubleToLongBits(v6) != Double.doubleToLongBits(other.v6))
			return false;
		if (Double.doubleToLongBits(v7) != Double.doubleToLongBits(other.v7))
			return false;
		if (Double.doubleToLongBits(v8) != Double.doubleToLongBits(other.v8))
			return false;
		if (Double.doubleToLongBits(v9) != Double.doubleToLongBits(other.v9))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ContratoEnergia2DTO [id=" + id + ", id_distribuidora=" + id_distribuidora + ", id_cliente=" + id_cliente
				+ ", id_montantes=" + id_montantes + ", cow_id_contrato=" + cow_id_contrato + ", ano=" + ano
				+ ", preco=" + preco + ", flex_max=" + flex_max + ", flex_min=" + flex_min + ", e_sazo=" + e_sazo
				+ ", e_flex=" + e_flex + ", sazo_max=" + sazo_max + ", sazo_min=" + sazo_min + ", p_carga=" + p_carga
				+ ", n_contract=" + n_contract + ", v1=" + v1 + ", v2=" + v2 + ", v3=" + v3 + ", v4=" + v4 + ", v5="
				+ v5 + ", v6=" + v6 + ", v7=" + v7 + ", v8=" + v8 + ", v9=" + v9 + ", v10=" + v10 + ", v11=" + v11
				+ ", v12=" + v12 + "]";
	}

	
	
	
}
