package br.com.witzler.clientes.domain.dto;

public class ColaboradorDTO {
	
	private Integer id_colaborador;
	private String nome_colaborador;
	private String email;
	private String telefone_1;
	private String telefone_2;
	private String path_img;
	
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id_colaborador == null) ? 0 : id_colaborador.hashCode());
		result = prime * result + ((nome_colaborador == null) ? 0 : nome_colaborador.hashCode());
		result = prime * result + ((path_img == null) ? 0 : path_img.hashCode());
		result = prime * result + ((telefone_1 == null) ? 0 : telefone_1.hashCode());
		result = prime * result + ((telefone_2 == null) ? 0 : telefone_2.hashCode());
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
		ColaboradorDTO other = (ColaboradorDTO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		if (path_img == null) {
			if (other.path_img != null)
				return false;
		} else if (!path_img.equals(other.path_img))
			return false;
		if (telefone_1 == null) {
			if (other.telefone_1 != null)
				return false;
		} else if (!telefone_1.equals(other.telefone_1))
			return false;
		if (telefone_2 == null) {
			if (other.telefone_2 != null)
				return false;
		} else if (!telefone_2.equals(other.telefone_2))
			return false;
		return true;
	}
	
	
	
	
	

}
