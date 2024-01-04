package br.com.witzler.clientes.domain.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.witzler.clientes.domain.entity.WebLogin;

public interface WebLoginRepositorio extends JpaRepository<WebLogin, Integer>{
	
	/*
	 * Query que procura o login de acesso pelo nome do usuário
	 */
	@Query(value = "SELECT * FROM pc.web_login WHERE username = :username", nativeQuery = true)
	WebLogin listarWebLoginPorUsername(String username);
	
}
