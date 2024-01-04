package br.com.witzler.clientes.domain.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.witzler.clientes.domain.entity.AlertaReativos;

public interface AlertaReativosRepositorio extends JpaRepository<AlertaReativos, Integer>{
	
	@Query(value="SELECT * FROM pc.web_cliente_alerta_reativo where cliente_id = :cliente_id", nativeQuery=true)
	List<AlertaReativos> listandoAlertaReativos( @Param("cliente_id") Integer cliente_id );

	
	/*
	 * Query que permite atualizar valores de reativo de um cliente
	 * */
	@Query(value="UPDATE pc.web_cliente_alerta_reativo SET alertar_com= :alertar_com,intervalo= :intervalo WHERE cliente_id=(SELECT cliente_id FROM pc.web_unidades WHERE id_unidades= :id_unidade ); INSERT INTO pc.web_cliente_alerta_reativo (alertar_com, intervalo, cliente_id) SELECT alertar_com, intervalo, (SELECT cliente_id FROM pc.web_unidades WHERE id_unidades= :id_unidade) WHERE NOT EXISTS (SELECT cliente_id FROM pc.web_cliente_alerta_reativo WHERE cliente_id=(SELECT cliente_id FROM pc.web_unidades WHERE id_unidades= :id_unidade ))", nativeQuery=true)
	List<AlertaReativos> listandoUpdateAlertaReativos( @Param("alertar_com") double alertar_com,
													   @Param("intervalo") double intervalo,
													   @Param("id_unidade") Integer id_unidade);
}
