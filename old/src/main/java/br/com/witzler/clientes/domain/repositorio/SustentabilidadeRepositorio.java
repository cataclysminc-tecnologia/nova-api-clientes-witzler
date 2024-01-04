package br.com.witzler.clientes.domain.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.witzler.clientes.domain.entity.Sustentabilidade;

public interface SustentabilidadeRepositorio extends JpaRepository<Sustentabilidade, Integer>{
	
	
	// Lista info de sustentabilidade do cliente
	@Query(value="SELECT * FROM pc.web_sustentabilidade WHERE cliente_id = :cliente_id", nativeQuery=true)
	List<Sustentabilidade> listandoInfoSustentabilidade( @Param("cliente_id") Integer cliente_id);
	

}
