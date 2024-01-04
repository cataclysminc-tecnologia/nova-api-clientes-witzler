package br.com.witzler.clientes.domain.repositorio;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.witzler.clientes.domain.entity.Cliente;

public interface Clientes extends JpaRepository<Cliente, Integer> {

	List<Cliente> findByUsernameLike(String username);
	//Optional<Cliente> findByUsername(String username);
	
	@Query(value="select * from pc.web_login2 where username = :username", nativeQuery=true)
	List<Cliente> listarCliente(String username);


}
