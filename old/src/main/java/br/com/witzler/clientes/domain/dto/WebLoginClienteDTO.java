package br.com.witzler.clientes.domain.dto;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Id;

public class WebLoginClienteDTO {
	
	private Integer id;
	private Integer client_id;
	private Integer login_id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClient_id() {
		return client_id;
	}
	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}
	public Integer getLogin_id() {
		return login_id;
	}
	public void setLogin_id(Integer login_id) {
		this.login_id = login_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((client_id == null) ? 0 : client_id.hashCode());
		result = prime * result + ((login_id == null) ? 0 : login_id.hashCode());
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
		WebLoginClienteDTO other = (WebLoginClienteDTO) obj;
		return Objects.equals(client_id, other.client_id) && Objects.equals(id, other.id)
				&& Objects.equals(login_id, other.login_id);
	}
	
}
