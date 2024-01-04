package br.com.witzler.clientes.domain.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.witzler.clientes.domain.entity.PldHorario;

public interface PldHorarioRepositorio extends JpaRepository<PldHorario, Integer> {
	
	@Query(value = "SELECT * FROM pc.web_pld_horario_2 WHERE date_ref = :date_ref AND region = :region", nativeQuery = true)
	List<PldHorario> listandoPld( @Param("date_ref") Date date_ref, @Param("region") Integer region);

}
