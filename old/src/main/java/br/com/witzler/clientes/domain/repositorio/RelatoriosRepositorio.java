package br.com.witzler.clientes.domain.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.witzler.clientes.domain.entity.Relatorios;

public interface RelatoriosRepositorio extends JpaRepository<Relatorios, Integer> {

	// Consultar Leonardo
	@Query(value="SELECT * FROM pc.web_relatorio WHERE cow_unit_id = :unidade_id AND EXTRACT(MONTH FROM data_referencia)= :mes AND EXTRACT(YEAR FROM data_referencia)= :ano", nativeQuery=true)
	List<Relatorios> listandoRelatorios( @Param("unidade_id") Integer unidade_id, @Param("mes") Integer mes, @Param("ano") Integer ano );
	
}
