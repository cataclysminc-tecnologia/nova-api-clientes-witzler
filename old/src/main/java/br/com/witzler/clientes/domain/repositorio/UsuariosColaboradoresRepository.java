package br.com.witzler.clientes.domain.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.witzler.clientes.domain.entity.UsuariosColaboradores;

public interface UsuariosColaboradoresRepository extends JpaRepository<UsuariosColaboradores, Integer>{
	Optional<UsuariosColaboradores> findByUsername(String username);
	
	@Query(value="select * from pc.web_colaborador2 where username = :username", nativeQuery=true)
	List<UsuariosColaboradores> listandoTudo( String username );
	
	// Esta query devolve todos os clientes que um usuario colaborador específico tem
	@Query(value="select * from pc.web_cliente WHERE colaborador_tec_id = :colaborador_tec_id", nativeQuery=true)
	List<UsuariosColaboradores> listandoTudoClientes( int colaborador_tec_id );
}
