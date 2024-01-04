package br.com.witzler.clientes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.witzler.clientes.domain.entity.Usuario;
import br.com.witzler.clientes.domain.entity.WebCliente;
import br.com.witzler.clientes.domain.repositorio.WebClienteRepositorio;

@Service 
public class WebClienteServiceImpl {
	
	@Autowired
	private WebClienteRepositorio repository;

	public List<WebCliente> listandoClientesUsuarioColaborador(int colaborador_tec_id) {
		return repository.listandoTudoClientes(colaborador_tec_id);
	}
	
	public List<WebCliente> listandoTodosClientesUsuarioColaboradorAdmin() {
		return repository.listandoTodosClientes();
	}
	
	public List<WebCliente> listandoQtdeClientesUsuarioColaboradorAdmin() {
		return repository.listandoQtdeClientes();
	}
	
	public List<WebCliente> listandoInfoUsuarioPorId(int id_cliente) {
		return repository.listandoTudoPorId(id_cliente);
	}
	
}
