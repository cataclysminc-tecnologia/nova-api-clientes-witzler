package br.com.witzler.clientes.domain.dto;

import javax.persistence.Column;

public class ComercializadoraDTO {
	
	private Integer id_comercializadora;
	private String nome;
	private String path;
	private Integer cow_id;
	public Integer getId_comercializadora() {
		return id_comercializadora;
	}
	public void setId_comercializadora(Integer id_comercializadora) {
		this.id_comercializadora = id_comercializadora;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getCow_id() {
		return cow_id;
	}
	public void setCow_id(Integer cow_id) {
		this.cow_id = cow_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cow_id == null) ? 0 : cow_id.hashCode());
		result = prime * result + ((id_comercializadora == null) ? 0 : id_comercializadora.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
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
		ComercializadoraDTO other = (ComercializadoraDTO) obj;
		if (cow_id == null) {
			if (other.cow_id != null)
				return false;
		} else if (!cow_id.equals(other.cow_id))
			return false;
		if (id_comercializadora == null) {
			if (other.id_comercializadora != null)
				return false;
		} else if (!id_comercializadora.equals(other.id_comercializadora))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ComercializadoraDTO [id_comercializadora=" + id_comercializadora + ", nome=" + nome + ", path=" + path
				+ ", cow_id=" + cow_id + "]";
	}
	
	
}
