package br.com.witzler.clientes.domain.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.witzler.clientes.domain.entity.Unidades;

public interface UnidadesRepositorio extends JpaRepository<Unidades, Integer>{

	/*
	var query = 'SELECT * FROM pc.web_unidades WHERE cliente_id = '
    +' (SELECT client_id FROM pc.web_login_cliente INNER JOIN (SELECT id_login FROM pc.web_login WHERE  PGP_SYM_DECRYPT(username::bytea, $$' + "md5" + '$$) '
    +'  LIKE ($$' + userData.username + '$$) and PGP_SYM_DECRYPT(u_password::bytea, $$' + "md5" + '$$) LIKE ($$' + userData.password + '$$)) AS TABELA '
    +' ON TABELA.id_login = login_id)'*/
	
	/*
	 * Query que lista todas as unidades 
	 * */
	@Query(value = "SELECT * FROM pc.web_unidades WHERE cliente_id = (SELECT client_id FROM pc.web_login INNER JOIN pc.web_login_cliente ON id_login = login_id WHERE username = :username)", nativeQuery=true)
	List<Unidades> listandoUnidadesCliente(String username);
	
	
	
	
	
	
	
}
