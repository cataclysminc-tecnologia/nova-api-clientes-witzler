package br.com.witzler.clientes.domain.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.witzler.clientes.domain.entity.RelatorioResumo;

public interface RelatorioResumoRepositorio extends JpaRepository<RelatorioResumo, Integer> {

	/*
	 * 14/04/2021
	 * TI Witzler Team
	 * Query que lista todas as informações de relatório de uma unidade específica
	 * */
	@Query(value = "SELECT * FROM pc.web_relatorio_resumo where id_unid = :id_unid AND data_ref = :data_ref", nativeQuery = true)
	List<RelatorioResumo> listarRelatorio(@Param("id_unid") Integer id_unid,
										  @Param("data_ref") Date data_ref);
	
}
