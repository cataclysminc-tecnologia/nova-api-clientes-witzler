package br.com.witzler.clientes.domain.dto;

import java.util.Objects;

public class WebClienteDTO {

	Integer id_cliente;
	String nome;
	String email;
	String username;
	String nome_fantasia;
	Integer colaborador_tec_id;
	Integer colaborador_comercial_id;
	Integer cow_client_id;
	String email_recp;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getEmail_recp() {
		return email_recp;
	}
	public void setEmail_recp(String email_recp) {
		this.email_recp = email_recp;
	}
	@Override
	public int hashCode() {
		return Objects.hash(colaborador_comercial_id, colaborador_tec_id, cow_client_id, email, email_recp, id_cliente,
				nome, nome_fantasia, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebClienteDTO other = (WebClienteDTO) obj;
		return Objects.equals(colaborador_comercial_id, other.colaborador_comercial_id)
				&& Objects.equals(colaborador_tec_id, other.colaborador_tec_id)
				&& Objects.equals(cow_client_id, other.cow_client_id) && Objects.equals(email, other.email)
				&& Objects.equals(email_recp, other.email_recp) && Objects.equals(id_cliente, other.id_cliente)
				&& Objects.equals(nome, other.nome) && Objects.equals(nome_fantasia, other.nome_fantasia)
				&& Objects.equals(username, other.username);
	}
	
	
	
	
	
}
