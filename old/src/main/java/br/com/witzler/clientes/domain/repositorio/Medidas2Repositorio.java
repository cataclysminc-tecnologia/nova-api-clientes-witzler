package br.com.witzler.clientes.domain.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.witzler.clientes.domain.entity.Medidas2;

public interface Medidas2Repositorio extends JpaRepository<Medidas2, Integer>{
	
	
	
	// /medidas/fatorPotenciaHora
			@Query(value="(SELECT COS(ATAN(reativo_g/ativo_c)) AS Capacitivo, hora_do_dia, id_medidas, ativo_c, ativo_g, data_medicao, dia_da_semana,reativo_c, reativo_g, status, tipo_medida, unidade_id FROM pc.web_listar_medidas WHERE data_medicao = :data_busca and unidade_id = :unidade_id and hora_do_dia <6 and status <> 10 ) union all (SELECT COS(ATAN(reativo_c/ativo_c)) AS Indutivo, hora_do_dia, id_medidas, ativo_c, ativo_g, data_medicao, dia_da_semana,reativo_c, reativo_g, status, tipo_medida, unidade_id FROM pc.web_listar_medidas WHERE  data_medicao = :data_busca and unidade_id = :unidade_id and hora_do_dia >=6 and status <> 10) ORDER BY hora_do_dia ASC", nativeQuery=true)
			List<Medidas2> listarFatorPotenciaHora(@Param("unidade_id") Integer unidade_id,
												   @Param("data_busca") Date data_busca);
			//private String medidor = "SPGRGCENTR101";

}
