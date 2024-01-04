package br.com.witzler.clientes.domain.dto;

public class ClienteInfoDTO {
	
	Integer id_cliente;
	String nome;
	String email;
	String nome_fantasia;
	Integer colaborador_tec_id;
	Integer colaborador_comercial_id;
	Integer cow_client_id;
	Integer type_client;
	
	public Integer getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome_fantasia() {
		return nome_fantasia;
	}
	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}
	public Integer getColaborador_tec_id() {
		return colaborador_tec_id;
	}
	public void setColaborador_tec_id(Integer colaborador_tec_id) {
		this.colaborador_tec_id = colaborador_tec_id;
	}
	public Integer getColaborador_comercial_id() {
		return colaborador_comercial_id;
	}
	public void setColaborador_comercial_id(Integer colaborador_comercial_id) {
		this.colaborador_comercial_id = colaborador_comercial_id;
	}
	public Integer getCow_client_id() {
		return cow_client_id;
	}
	public void setCow_client_id(Integer cow_client_id) {
		this.cow_client_id = cow_client_id;
	}
	public Integer getType_client() {
		return type_client;
	}
	public void setType_client(Integer type_client) {
		this.type_client = type_client;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colaborador_comercial_id == null) ? 0 : colaborador_comercial_id.hashCode());
		result = prime * result + ((colaborador_tec_id == null) ? 0 : colaborador_tec_id.hashCode());
		result = prime * result + ((cow_client_id == null) ? 0 : cow_client_id.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id_cliente == null) ? 0 : id_cliente.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nome_fantasia == null) ? 0 : nome_fantasia.hashCode());
		result = prime * result + ((type_client == null) ? 0 : type_client.hashCode());
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
		ClienteInfoDTO other = (ClienteInfoDTO) obj;
		if (colaborador_comercial_id == null) {
			if (other.colaborador_comercial_id != null)
				return false;
		} else if (!colaborador_comercial_id.equals(other.colaborador_comercial_id))
			return false;
		if (colaborador_tec_id == null) {
			if (other.colaborador_tec_id != null)
				return false;
		} else if (!colaborador_tec_id.equals(other.colaborador_tec_id))
			return false;
		if (cow_client_id == null) {
			if (other.cow_client_id != null)
				return false;
		} else if (!cow_client_id.equals(other.cow_client_id))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id_cliente == null) {
			if (other.id_cliente != null)
				return false;
		} else if (!id_cliente.equals(other.id_cliente))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nome_fantasia == null) {
			if (other.nome_fantasia != null)
				return false;
		} else if (!nome_fantasia.equals(other.nome_fantasia))
			return false;
		if (type_client == null) {
			if (other.type_client != null)
				return false;
		} else if (!type_client.equals(other.type_client))
			return false;
		return true;
	}
	
	
	
	

}
