package br.com.witzler.clientes.domain.dto;


public class EspelhoAclDTO {

	private Integer distribuidora_id;
	private Integer tarifa;
	private Integer tipo_texto;
	private Integer linha;
	private Integer coluna;
	private String texto_1;
	private String texto_2;
	
	public Integer getDistribuidora_id() {
		return distribuidora_id;
	}
	public void setDistribuidora_id(Integer distribuidora_id) {
		this.distribuidora_id = distribuidora_id;
	}
	public Integer getTarifa() {
		return tarifa;
	}
	public void setTarifa(Integer tarifa) {
		this.tarifa = tarifa;
	}
	public Integer getTipo_texto() {
		return tipo_texto;
	}
	public void setTipo_texto(Integer tipo_texto) {
		this.tipo_texto = tipo_texto;
	}
	public Integer getLinha() {
		return linha;
	}
	public void setLinha(Integer linha) {
		this.linha = linha;
	}
	public Integer getColuna() {
		return coluna;
	}
	public void setColuna(Integer coluna) {
		this.coluna = coluna;
	}
	public String getTexto_1() {
		return texto_1;
	}
	public void setTexto_1(String texto_1) {
		this.texto_1 = texto_1;
	}
	public String getTexto_2() {
		return texto_2;
	}
	public void setTexto_2(String texto_2) {
		this.texto_2 = texto_2;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coluna == null) ? 0 : coluna.hashCode());
		result = prime * result + ((distribuidora_id == null) ? 0 : distribuidora_id.hashCode());
		result = prime * result + ((linha == null) ? 0 : linha.hashCode());
		result = prime * result + ((tarifa == null) ? 0 : tarifa.hashCode());
		result = prime * result + ((texto_1 == null) ? 0 : texto_1.hashCode());
		result = prime * result + ((texto_2 == null) ? 0 : texto_2.hashCode());
		result = prime * result + ((tipo_texto == null) ? 0 : tipo_texto.hashCode());
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
		EspelhoAclDTO other = (EspelhoAclDTO) obj;
		if (coluna == null) {
			if (other.coluna != null)
				return false;
		} else if (!coluna.equals(other.coluna))
			return false;
		if (distribuidora_id == null) {
			if (other.distribuidora_id != null)
				return false;
		} else if (!distribuidora_id.equals(other.distribuidora_id))
			return false;
		if (linha == null) {
			if (other.linha != null)
				return false;
		} else if (!linha.equals(other.linha))
			return false;
		if (tarifa == null) {
			if (other.tarifa != null)
				return false;
		} else if (!tarifa.equals(other.tarifa))
			return false;
		if (texto_1 == null) {
			if (other.texto_1 != null)
				return false;
		} else if (!texto_1.equals(other.texto_1))
			return false;
		if (texto_2 == null) {
			if (other.texto_2 != null)
				return false;
		} else if (!texto_2.equals(other.texto_2))
			return false;
		if (tipo_texto == null) {
			if (other.tipo_texto != null)
				return false;
		} else if (!tipo_texto.equals(other.tipo_texto))
			return false;
		return true;
	}

}
