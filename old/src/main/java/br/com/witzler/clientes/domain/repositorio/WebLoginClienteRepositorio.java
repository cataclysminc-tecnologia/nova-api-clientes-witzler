package br.com.witzler.clientes.domain.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.witzler.clientes.domain.entity.WebLoginCliente;

public interface WebLoginClienteRepositorio extends JpaRepository<WebLoginCliente, Integer>{
	
	/*
	 * Query que procura o WebLoginCliente pelo login_id
	 */
	@Query(value = "SELECT * FROM pc.web_login_cliente WHERE login_id = :login_id", nativeQuery = true)
	WebLoginCliente listarWebLoginClientePeloLoginId(Integer login_id);
	
}
