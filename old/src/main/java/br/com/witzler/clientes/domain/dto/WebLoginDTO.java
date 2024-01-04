package br.com.witzler.clientes.domain.dto;

import java.util.Objects;

import javax.persistence.Column;

public class WebLoginDTO {
	
	private Integer id_login;
	private String username;
	private String u_password;
	private Boolean admin;
	
	public Integer getId_login() {
		return id_login;
	}
	public void setId_login(Integer id_login) {
		this.id_login = id_login;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public Boolean isAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_login == null) ? 0 : id_login.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((u_password == null) ? 0 : u_password.hashCode());
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
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
		WebLoginDTO other = (WebLoginDTO) obj;
		return admin == other.admin && Objects.equals(id_login, other.id_login)
				&& Objects.equals(u_password, other.u_password) && Objects.equals(username, other.username);
	}
	
	
}
