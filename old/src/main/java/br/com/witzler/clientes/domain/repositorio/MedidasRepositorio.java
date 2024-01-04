package br.com.witzler.clientes.domain.repositorio;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.witzler.clientes.domain.entity.Medidas;
import br.com.witzler.clientes.domain.entity.PerformanceUnidades;

public interface MedidasRepositorio extends JpaRepository<Medidas, Integer> {

	
	/**
	 * 27/05/2020
	 * TI Witzler Team
	 * Query que retorna medidas de 1 dia
	 * SELECT * FROM pc.web_listar_medidas 
	 * */
	@Query(value="SELECT * FROM pc.web_listar_medidas where status <> 10;", nativeQuery=true)
	List<Medidas> listarMedidasTudo();
	
	
	
	/**
	 * 27/05/2020
	 * TI Witzler Team
	 * Query que retorna medidas de 1 dia
	 * SELECT ativo_c, data_medicao, hora_do_dia FROM pc.web_listar_medidas WHERE unidade_id = '947' AND  data_medicao = '2020-01-01'
	 * */
	@Query(value="SELECT * FROM pc.web_listar_medidas WHERE unidade_id = :unidade_id AND  data_medicao = :data_medicao where status <> 10", nativeQuery=true)
	List<Medidas> listarMedidasUmDia(@Param("unidade_id") Integer unidade_id,
									 @Param("data_medicao") Date data_medicao);
	
	
	
	
	/**
	 * 27/05/2020
	 * TI Witzler Team
	 * Query que retorna medidas de um certo periodo
	 * SELECT ativo_c, data_medicao, hora_do_dia FROM pc.web_listar_medidas WHERE unidade_id = '947' AND  (data_medicao >= :dataInicial AND data_medicao <= :dataFinal)
	 * */
	@Query(value="SELECT * FROM pc.web_listar_medidas WHERE unidade_id = :unidade_id AND  (data_medicao >= :dataInicial AND data_medicao <= :dataFinal) and status <> 10", nativeQuery=true)
	List<Medidas> listarMedidasPeriodo(@Param("unidade_id") Integer unidade_id,
									 @Param("dataInicial") Date dataInicial,
									 @Param("dataFinal") Date dataFinal);

	
	
	/**
	 * 27/05/2020
	 * TI Witzler Team
	 * Query que retorna medidas fora ponta 
	 * SELECT ativo_c, data_medicao, hora_do_dia FROM pc.web_listar_medidas WHERE unidade_id = '947' AND  (data_medicao >= '2020-01-01' AND data_medicao <= '2020-02-01')
	 * */
	@Query(value="SELECT *  FROM pc.web_listar_medidas WHERE unidade_id = :unidade_id AND  (data_medicao >= :dataInicial AND data_medicao <= :dataFinal) and status <> 10 ORDER BY data_medicao ASC, hora_do_dia ASC ", nativeQuery=true)
	List<Medidas> listarMedidasPeriodoForaPonta(@Param("unidade_id") Integer unidade_id,
									 @Param("dataInicial") Date dataInicial,
									 @Param("dataFinal") Date dataFinal);
	
	
	
	@Query(value="SELECT *  FROM pc.web_listar_medidas WHERE unidade_id = :unidade_id AND  (data_medicao >= :dataInicial AND data_medicao <= :dataFinal) and status <> 10 ORDER BY data_medicao ASC, hora_do_dia ASC", nativeQuery=true)
	List<Medidas> listarMedidasPeriodoForaPontaDiario(@Param("unidade_id") Integer unidade_id,
									 @Param("dataInicial") Date dataInicial,
									 @Param("dataFinal") Date dataFinal);
	
	
	
	
	// /medidas/mediafatorPotencia/capacitivo
//	@Query(value="SELECT id_medidas, ativo_c, reativo_c, ativo_g, reativo_g, dia_da_semana, data_medicao, hora_do_dia, unidade_id, tipo_medida, status, id_medidas FROM pc.web_listar_medidas WHERE (data_medicao >= :data_inicial and data_medicao < :data_final) and unidade_id = :unidade_id and hora_do_dia < 7 and ativo_c<> 0", nativeQuery=true)
//	List<Medidas> listarMediaFatorPotenciaCapacitivo(@Param("unidade_id") Integer unidade_id,
//				@Param("data_inicial") Date data_inicial, 
//				@Param("data_final") Date data_final);
	@Query(value="SELECT id_medidas, ativo_c, reativo_c, ativo_g, reativo_g, dia_da_semana, data_medicao, hora_do_dia, unidade_id, tipo_medida, status, id_medidas FROM pc.web_listar_medidas WHERE (data_medicao >= :data_inicial and data_medicao < :data_final) and unidade_id = :unidade_id and hora_do_dia < 7 and ativo_c<> 0 and status <> 10", nativeQuery=true)
	List<Medidas> listarMediaFatorPotenciaCapacitivo(@Param("unidade_id") Integer unidade_id,
				@Param("data_inicial") Date data_inicial, 
				@Param("data_final") Date data_final);
	//private String medidor = "SPGRGCENTR101";
	
	
	
	
	
	// /medidas/mediafatorPotencia/indutivo
		@Query(value="SELECT id_medidas, ativo_c, reativo_c, ativo_g, reativo_g, dia_da_semana, data_medicao, hora_do_dia, unidade_id, tipo_medida, status FROM pc.web_listar_medidas WHERE (data_medicao >= :data_inicial and data_medicao < :data_final) and unidade_id = :unidade_id and hora_do_dia >7 and ativo_c<> 0 and status <> 10", nativeQuery=true)
		List<Medidas> listarMediaFatorPotenciaIndutivo(@Param("unidade_id") Integer unidade_id,
					@Param("data_inicial") Date data_inicial, 
					@Param("data_final") Date data_final);
		//private String medidor = "SPGRGCENTR101";
		
		
		
	
		// /medidas/periodoAtivoC
		@Query(value=" SELECT * FROM pc.web_listar_medidas WHERE data_medicao = :data_busca and unidade_id = :unidade_id and status <> 10 ORDER BY hora_do_dia ASC; ", nativeQuery=true)
		List<Medidas> listarPeriodoAtivoC(@Param("unidade_id") Integer unidade_id,
				@Param("data_busca") Date data_busca);
		//private String medidor = "SPGRGCENTR101";	
		
		
		
		/*
		 * Query que lista valores onde serão somados os ativo_c de cada unidade para cálculo de CO2
		 * */
		@Query(value="SELECT * FROM pc.web_listar_medidas AA INNER JOIN pc.web_unidades BB ON AA.unidade_id = BB.id_unidades WHERE BB.id_unidades IN (SELECT id_unidades FROM pc.web_unidades WHERE cliente_id  = (SELECT cliente_id FROM pc.web_unidades WHERE id_unidades = :id_unidades)) ;", nativeQuery=true)
		List<Medidas> listandoCO2(@Param("id_unidades") Integer id_unidades);
		
		
		
		

	
	
	
	/*
	
	// /medidas/periodoForaPonta
	//@Query(value="SELECT t1.foraPonta,t2.ponta,t1.data_medicao From ((SELECT Sum(ativo_c) AS foraPonta, data_medicao FROM pc.web_listar_medidas WHERE unidade_id = :unidade_id AND (data_medicao >= :dataInicial AND data_medicao <= :dataFinal) AND (hora_do_dia >=18 and hora_do_dia <= 20) GROUP BY data_medicao  ORDER BY data_medicao ASC)) AS t1,((SELECT Sum(ativo_c) as Ponta, data_medicao FROM pc.web_listar_medidas WHERE unidade_id = :unidade_id AND (data_medicao >= :dataInicial AND data_medicao <= :dataFinal AND ((hora_do_dia >=0 and hora_do_dia <=17) or (hora_do_dia >=21 and hora_do_dia <=23)))  GROUP BY data_medicao  ORDER BY data_medicao ASC)) AS t2 WHERE t2.data_medicao = t1.data_medicao ORDER BY t2.data_medicao ASC;",nativeQuery=true)
	//Query(value="select new MedidasForaPontaDTO(t1.foraPonta,t2.ponta,t1.data_medicao From ((SELECT Sum(ativo_c) AS foraPonta, data_medicao FROM pc.web_listar_medidas WHERE unidade_id = :unidade_id AND (data_medicao >= :dataInicial AND data_medicao <= :dataFinal) AND (hora_do_dia >=18 and hora_do_dia <= 20) GROUP BY data_medicao  ORDER BY data_medicao ASC)) AS t1,((SELECT Sum(ativo_c) as Ponta, data_medicao FROM pc.web_listar_medidas WHERE unidade_id = :unidade_id AND (data_medicao >= :dataInicial AND data_medicao <= :dataFinal AND ((hora_do_dia >=0 and hora_do_dia <=17) or (hora_do_dia >=21 and hora_do_dia <=23)))  GROUP BY data_medicao  ORDER BY data_medicao ASC)) AS t2 WHERE t2.data_medicao = t1.data_medicao ORDER BY t2.data_medicao ASC; )", nativeQuery=true)
	List<Medidas> listarPeriodoForaPonta(@Param("unidade_id") Integer unidade_id,
			@Param("dataInicial") Date dataInicial, 
			@Param("dataFinal") Date dataFinal );
	
	
	///medidas/periodoSomaPontaForaPonta
	@Query(value=" SELECT SUM(t1.foraPonta) AS foraPonta ,Sum(t2.ponta) AS ponta From ((SELECT Sum(ativo_c)  AS foraPonta, data_medicao FROM pc.web_listar_medidas WHERE unidade_id = :unidade_id AND  (data_medicao >= :dataInicial AND data_medicao <= :dataFinal AND (hora_do_dia >=18 and hora_do_dia <= 20) GROUP BY data_medicao  ORDER BY data_medicao ASC)) AS t1,((SELECT Sum(ativo_c) as Ponta, data_medicao FROM pc.web_listar_medidas WHERE unidade_id = :unidade_id AND  (data_medicao >= :dataInicial AND data_medicao <= :dataFinal) AND ((hora_do_dia >=0 and hora_do_dia <=17) or (hora_do_dia >=21 and hora_do_dia <=23))  GROUP BY data_medicao  ORDER BY data_medicao ASC)) AS t2 WHERE t2.data_medicao = t1.data_medicao; ", nativeQuery=true)
	List<Medidas> listarPeriodoSomaPontaForaPonta(@Param("unidade_id") Integer unidade_id,
			@Param("dataInicial") Date dataInicial, 
			@Param("dataFinal") Date dataFinal);
	//private String medidor = "SPGRGCENTR101";
	
	*/
	
	
	
	
	
	

	
	
	
	
	
	
	
}
