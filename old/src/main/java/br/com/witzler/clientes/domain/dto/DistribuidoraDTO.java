package br.com.witzler.clientes.domain.dto;

public class DistribuidoraDTO {
	
	private Integer id_distribuidora;
	private String nome_distribuidora;
	private String descricao_distribuidora;
	
	public Integer getId_distribuidora() {
		return id_distribuidora;
	}
	public void setId_distribuidora(Integer id_distribuidora) {
		this.id_distribuidora = id_distribuidora;
	}
	public String getNome_distribuidora() {
		return nome_distribuidora;
	}
	public void setNome_distribuidora(String nome_distribuidora) {
		this.nome_distribuidora = nome_distribuidora;
	}
	public String getDescricao_distribuidora() {
		return descricao_distribuidora;
	}
	public void setDescricao_distribuidora(String descricao_distribuidora) {
		this.descricao_distribuidora = descricao_distribuidora;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao_distribuidora == null) ? 0 : descricao_distribuidora.hashCode());
		result = prime * result + ((id_distribuidora == null) ? 0 : id_distribuidora.hashCode());
		result = prime * result + ((nome_distribuidora == null) ? 0 : nome_distribuidora.hashCode());
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
		DistribuidoraDTO other = (DistribuidoraDTO) obj;
		if (descricao_distribuidora == null) {
			if (other.descricao_distribuidora != null)
				return false;
		} else if (!descricao_distribuidora.equals(other.descricao_distribuidora))
			return false;
		if (id_distribuidora == null) {
			if (other.id_distribuidora != null)
				return false;
		} else if (!id_distribuidora.equals(other.id_distribuidora))
			return false;
		if (nome_distribuidora == null) {
			if (other.nome_distribuidora != null)
				return false;
		} else if (!nome_distribuidora.equals(other.nome_distribuidora))
			return false;
		return true;
	}
	
	


}
