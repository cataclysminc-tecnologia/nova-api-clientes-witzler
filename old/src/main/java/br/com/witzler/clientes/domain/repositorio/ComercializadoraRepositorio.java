package br.com.witzler.clientes.domain.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.witzler.clientes.domain.entity.Comercializadora;

public interface ComercializadoraRepositorio extends JpaRepository<Comercializadora, Integer> {

	@Query(value="select * from pc.web_comercializadora where id_comercializadora = :id_comercializadora", nativeQuery=true)
	List<Comercializadora> listandoInfoComercializadora( @Param("id_comercializadora") Integer id_comercializadora);
	
}
