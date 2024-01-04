package br.com.witzler.clientes.domain.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.witzler.clientes.domain.entity.WebPrevia;

public interface WebPreviaRepositorio extends JpaRepository<WebPrevia, Integer> {
	
	/*
	 * Query que lista valores de previas de uma certa unidade e uma certa data
	 * 16/10/2020
	 * 
	 * */
	@Query(value="select * from pc.web_previa WHERE unidade_id = :unidade_id AND data_previa = :data_previa", nativeQuery=true)
	List<WebPrevia> listarPrevias(@Param("unidade_id") Integer unidade_id, 
								  @Param("data_previa") Date data_previa);

}
