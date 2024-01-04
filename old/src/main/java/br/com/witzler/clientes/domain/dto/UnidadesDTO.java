package br.com.witzler.clientes.domain.dto;

public class UnidadesDTO {
	
	private Integer id_unidades;
	private String nome;
	private Integer cliente_id;
	private String medidor;
	private String distribuidora;
	private String uc_unidade;
	
	public String getUc_unidade() {
		return uc_unidade;
	}
	public void setUc_unidade(String uc_unidade) {
		this.uc_unidade = uc_unidade;
	}
	public Integer getId_unidades() {
		return id_unidades;
	}
	public void setId_unidades(Integer id_unidades) {
		this.id_unidades = id_unidades;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}
	public String getMedidor() {
		return medidor;
	}
	public void setMedidor(String medidor) {
		this.medidor = medidor;
	}
	public String getDistribuidora() {
		return distribuidora;
	}
	public void setDistribuidora(String distribuidora) {
		this.distribuidora = distribuidora;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente_id == null) ? 0 : cliente_id.hashCode());
		result = prime * result + ((distribuidora == null) ? 0 : distribuidora.hashCode());
		result = prime * result + ((id_unidades == null) ? 0 : id_unidades.hashCode());
		result = prime * result + ((medidor == null) ? 0 : medidor.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((uc_unidade == null) ? 0 : uc_unidade.hashCode());
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
		UnidadesDTO other = (UnidadesDTO) obj;
		if (cliente_id == null) {
			if (other.cliente_id != null)
				return false;
		} else if (!cliente_id.equals(other.cliente_id))
			return false;
		if (distribuidora == null) {
			if (other.distribuidora != null)
				return false;
		} else if (!distribuidora.equals(other.distribuidora))
			return false;
		if (id_unidades == null) {
			if (other.id_unidades != null)
				return false;
		} else if (!id_unidades.equals(other.id_unidades))
			return false;
		if (medidor == null) {
			if (other.medidor != null)
				return false;
		} else if (!medidor.equals(other.medidor))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (uc_unidade == null) {
			if (other.uc_unidade != null)
				return false;
		} else if (!uc_unidade.equals(other.uc_unidade))
			return false;
		return true;
	}
	
	
	
	
	
	

}
