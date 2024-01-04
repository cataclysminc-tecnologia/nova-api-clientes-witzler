package br.com.witzler.clientes.domain.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.witzler.clientes.domain.entity.ClienteInfo;

public interface ClienteInfoRepositorio extends JpaRepository<ClienteInfo, Integer> {

	@Query(value = "select * from pc.web_cliente where id_cliente = :id_cliente", nativeQuery=true)
	List<ClienteInfo> listarInfoCliente(Integer id_cliente);
	
}
