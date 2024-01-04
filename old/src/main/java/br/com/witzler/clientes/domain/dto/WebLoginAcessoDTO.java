package br.com.witzler.clientes.domain.dto;

public class WebLoginAcessoDTO {
	
	private Integer id;
	private String nome;
	private String data_login;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getData_login() {
		return data_login;
	}
	public void setData_login(String data_login) {
		this.data_login = data_login;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_login == null) ? 0 : data_login.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		WebLoginAcessoDTO other = (WebLoginAcessoDTO) obj;
		if (data_login == null) {
			if (other.data_login != null)
				return false;
		} else if (!data_login.equals(other.data_login))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "WebLoginAcessoDTO [id=" + id + ", nome=" + nome + ", data_login=" + data_login + "]";
	}
	
	

}
