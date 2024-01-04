/*
 * Interface da performance de Unidades 13 Meses
 * 03/06/2020
 * TI Witzlert Team
 * 
 * */



package br.com.witzler.clientes.domain.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.witzler.clientes.domain.entity.PerformanceUnidades;

public interface PerformanceUnidadesRepositorio extends JpaRepository<PerformanceUnidades, Integer>{

	/*
	 * Query que retorna resultados dos ultimos 13 meses
	 * 
	 * */
	@Query(value="SELECT AA.id_performance,AA.unit_cow_id, AA.data_referencia, AA.valor_economizado, AA.porcentagem_economia FROM pc.web_performance_unidades AA INNER JOIN pc.web_unidades  BB ON AA.unit_cow_id = BB.cow_unit_id WHERE BB.id_unidades = :id_unidade ORDER BY data_referencia DESC LIMIT 13", nativeQuery=true)
	List<PerformanceUnidades> listandoEconomia13Meses(@Param("id_unidade") Integer id_unidade);
	//PerformanceUnidades listandoEconomia13Meses(Integer id_unidade);

	
	/*
	 * Query que lista total de economia do cliente Histórico de Economia Consolidado: ACL X ACR
	 * 
	 * */
	@Query(value="SELECT unp.id_performance, porcentagem_economia, unit_cow_id, valor_economizado, SUM(UNP.valor_economizado) AS SUMVALUEP, UNP.data_referencia FROM (pc.web_unidades UN INNER JOIN pc.web_cliente CL ON CL.id_cliente = UN.cliente_id) INNER JOIN pc.web_performance_unidades UNP ON UNP.unit_cow_id = UN.cow_unit_id WHERE CL.id_cliente = (SELECT client_id FROM pc.web_login_cliente INNER JOIN (SELECT id_login FROM pc.web_login WHERE  username = :username )AS TABELA ON TABELA.id_login = login_id) GROUP BY unp.id_performance, UNP.data_referencia ORDER BY UNP.data_referencia DESC;", nativeQuery=true)
	List<PerformanceUnidades> listandoEconomiaTotalCliente(@Param("username") String username);
	
	
	/*
	 * Query que lista total de economia da unidade
	 * 
	 * */
	@Query(value="SELECT AA.id_performance,AA.unit_cow_id, AA.data_referencia, AA.valor_economizado, AA.porcentagem_economia FROM pc.web_performance_unidades AA INNER JOIN pc.web_unidades  BB ON AA.unit_cow_id = BB.cow_unit_id WHERE BB.id_unidades = :id_unidades ORDER BY data_referencia", nativeQuery=true)
	List<PerformanceUnidades> listandoEconomiaTotalUnidade(@Param("id_unidades") Integer id_unidades );
	
	
	
}
