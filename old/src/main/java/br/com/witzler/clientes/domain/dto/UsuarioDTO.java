package br.com.witzler.clientes.domain.dto;

public class UsuarioDTO {
	
	private Integer id_login;
	private String username;
	private String u_password;
	private boolean admin;
	
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
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (admin ? 1231 : 1237);
		result = prime * result + ((id_login == null) ? 0 : id_login.hashCode());
		result = prime * result + ((u_password == null) ? 0 : u_password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		UsuarioDTO other = (UsuarioDTO) obj;
		if (admin != other.admin)
			return false;
		if (id_login == null) {
			if (other.id_login != null)
				return false;
		} else if (!id_login.equals(other.id_login))
			return false;
		if (u_password == null) {
			if (other.u_password != null)
				return false;
		} else if (!u_password.equals(other.u_password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
	
	

}
