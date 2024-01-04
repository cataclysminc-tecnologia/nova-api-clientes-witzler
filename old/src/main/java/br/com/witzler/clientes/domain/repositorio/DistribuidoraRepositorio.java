package br.com.witzler.clientes.domain.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.witzler.clientes.domain.entity.Distribuidora;

public interface DistribuidoraRepositorio extends JpaRepository<Distribuidora, Integer> {

	
	@Query(value = "select * from pc.web_distribuidora where id_distribuidora = :id_distribuidora", nativeQuery=true)
	List<Distribuidora> listarDistribuidora( Integer id_distribuidora );
	
}
