package br.com.witzler.clientes.domain.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.witzler.clientes.domain.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Optional<Usuario> findByUsername(String username);
	
	@Query(value="select * from pc.web_login where username = :username", nativeQuery=true)
	List<Usuario> listandoTudo( String username );
	
	
	//Usuario findByUsername2(Usuario usuario);

}
