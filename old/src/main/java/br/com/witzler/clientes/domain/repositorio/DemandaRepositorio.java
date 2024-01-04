package br.com.witzler.clientes.domain.repositorio;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.witzler.clientes.domain.entity.Demanda;

public interface DemandaRepositorio extends JpaRepository<Demanda, Integer>{
	@Query(value = "SELECT * FROM pc.web_unidade_demanda2 WHERE unidade_id = :unidade_id AND mes_ref = :mes_ref", nativeQuery = true)
	List<Demanda> listandoDemanda( @Param("unidade_id") int unidade_id, @Param("mes_ref") @DateTimeFormat(pattern = "yyyy-MM-dd") Date mes_ref);
	
	
	@Query(value = "SELECT * FROM pc.web_unidade_demanda2 WHERE unidade_id = :unidade_id AND (mes_ref >= :dataInicial AND mes_ref <= :dataFinal) ORDER BY mes_ref ASC", nativeQuery = true)
	List<Demanda> listaDemandaPrazo(
			@Param("unidade_id") int unidade_id, 
			@Param("dataInicial") Date dataInicial,
			@Param("dataFinal") Date dataFinal
	);
}
