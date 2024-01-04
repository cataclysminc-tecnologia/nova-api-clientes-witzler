package br.com.witzler.clientes.domain.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class WebRecuperacaoDTO {

	private Integer id;
	private String utilizador;
	private String confirmacao;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUtilizador() {
		return utilizador;
	}
	public void setUtilizador(String utilizador) {
		this.utilizador = utilizador;
	}
	public String getConfirmacao() {
		return confirmacao;
	}
	public void setConfirmacao(String confirmacao) {
		this.confirmacao = confirmacao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((confirmacao == null) ? 0 : confirmacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((utilizador == null) ? 0 : utilizador.hashCode());
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
		WebRecuperacaoDTO other = (WebRecuperacaoDTO) obj;
		if (confirmacao == null) {
			if (other.confirmacao != null)
				return false;
		} else if (!confirmacao.equals(other.confirmacao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (utilizador == null) {
			if (other.utilizador != null)
				return false;
		} else if (!utilizador.equals(other.utilizador))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "WebRecuperacaoDTO [id=" + id + ", utilizador=" + utilizador + ", confirmacao=" + confirmacao + "]";
	}
	
	

}
