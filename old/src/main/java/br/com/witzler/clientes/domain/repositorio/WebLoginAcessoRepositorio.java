package br.com.witzler.clientes.domain.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.witzler.clientes.domain.entity.WebLoginAcesso;

public interface WebLoginAcessoRepositorio extends JpaRepository<WebLoginAcesso, Integer>{
	
}
