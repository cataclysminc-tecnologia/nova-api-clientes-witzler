package br.com.witzler.clientes.domain.dto;

import java.util.Date;

public class ArquivosUnidadeTipoDTO {
	
	private Date data_referencia;
	private Integer tipo_arquivo;
	private String caminho;
	private String tipo_arquivo_descricao;
	
	public Date getData_referencia() {
		return data_referencia;
	}
	public void setData_referencia(Date data_referencia) {
		this.data_referencia = data_referencia;
	}
	public Integer getTipo_arquivo() {
		return tipo_arquivo;
	}
	public void setTipo_arquivo(Integer tipo_arquivo) {
		this.tipo_arquivo = tipo_arquivo;
	}
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	public String getTipo_arquivo_descricao() {
		return tipo_arquivo_descricao;
	}
	public void setTipo_arquivo_descricao(String tipo_arquivo_descricao) {
		this.tipo_arquivo_descricao = tipo_arquivo_descricao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caminho == null) ? 0 : caminho.hashCode());
		result = prime * result + ((data_referencia == null) ? 0 : data_referencia.hashCode());
		result = prime * result + ((tipo_arquivo == null) ? 0 : tipo_arquivo.hashCode());
		result = prime * result + ((tipo_arquivo_descricao == null) ? 0 : tipo_arquivo_descricao.hashCode());
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
		ArquivosUnidadeTipoDTO other = (ArquivosUnidadeTipoDTO) obj;
		if (caminho == null) {
			if (other.caminho != null)
				return false;
		} else if (!caminho.equals(other.caminho))
			return false;
		if (data_referencia == null) {
			if (other.data_referencia != null)
				return false;
		} else if (!data_referencia.equals(other.data_referencia))
			return false;
		if (tipo_arquivo == null) {
			if (other.tipo_arquivo != null)
				return false;
		} else if (!tipo_arquivo.equals(other.tipo_arquivo))
			return false;
		if (tipo_arquivo_descricao == null) {
			if (other.tipo_arquivo_descricao != null)
				return false;
		} else if (!tipo_arquivo_descricao.equals(other.tipo_arquivo_descricao))
			return false;
		return true;
	}
	
	
	

}
