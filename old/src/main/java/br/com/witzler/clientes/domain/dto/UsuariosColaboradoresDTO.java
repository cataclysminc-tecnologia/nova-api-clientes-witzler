package br.com.witzler.clientes.domain.dto;

public class UsuariosColaboradoresDTO {
	private Integer id_colaborador;
	private String nome_colaborador;
	private String email;
	private String telefone_1;
	private String telefone_2;
	private String path_img;
	private String username;
	private String password_colaborador;
	private boolean administrador;
	
	public Integer getId_colaborador() {
		return id_colaborador;
	}
	public void setId_colaborador(Integer id_colaborador) {
		this.id_colaborador = id_colaborador;
	}
	public String getNome_colaborador() {
		return nome_colaborador;
	}
	public void setNome_colaborador(String nome_colaborador) {
		this.nome_colaborador = nome_colaborador;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone_1() {
		return telefone_1;
	}
	public void setTelefone_1(String telefone_1) {
		this.telefone_1 = telefone_1;
	}
	public String getTelefone_2() {
		return telefone_2;
	}
	public void setTelefone_2(String telefone_2) {
		this.telefone_2 = telefone_2;
	}
	public String getPath_img() {
		return path_img;
	}
	public void setPath_img(String path_img) {
		this.path_img = path_img;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword_colaborador() {
		return password_colaborador;
	}
	public void setPassword_colaborador(String password_colaborador) {
		this.password_colaborador = password_colaborador;
	}
	public boolean isAdministrador() {
		return administrador;
	}
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (administrador ? 1231 : 1237);
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((password_colaborador == null) ? 0 : password_colaborador.hashCode());
		
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
		UsuariosColaboradoresDTO other = (UsuariosColaboradoresDTO) obj;
		if (administrador != other.administrador)
			return false;
		if (id_colaborador == null) {
			if (other.id_colaborador != null)
				return false;
		} else if (!id_colaborador.equals(other.id_colaborador))
			return false;
		if (nome_colaborador == null) {
			if (other.nome_colaborador != null)
				return false;
		} else if (!nome_colaborador.equals(other.nome_colaborador))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(email))
			return false;
		if (telefone_1 == null) {
			if (other.telefone_1 != null)
				return false;
		} else if (!telefone_1.equals(telefone_1))
			return false;
		if (telefone_2 == null) {
			if (other.telefone_2 != null)
				return false;
		} else if (!telefone_2.equals(telefone_2))
			return false;
		if (path_img == null) {
			if (other.path_img != null)
				return false;
		} else if (!path_img.equals(path_img))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (password_colaborador == null) {
			if (other.password_colaborador != null)
				return false;
		} else if (!password_colaborador.equals(other.password_colaborador))
			return false;
		return true;
	}
}
