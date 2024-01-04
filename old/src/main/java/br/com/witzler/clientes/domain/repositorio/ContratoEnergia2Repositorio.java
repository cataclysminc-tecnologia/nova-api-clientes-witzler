package br.com.witzler.clientes.domain.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.witzler.clientes.domain.entity.ContratoEnergia2;

public interface ContratoEnergia2Repositorio extends JpaRepository<ContratoEnergia2, Integer>{
	
	//SELECT *FROM pc.web_contrato_energia2 as ce INNER JOIN pc.web_contrato_montantes AS cm ON ce.id_montantes = cm.id where ce.id_cliente = (SELECT cliente_id FROM pc.web_unidades where id_unidades = :id_unidades)
	@Query(value="SELECT * FROM pc.web_contrato_energia2 as ce INNER JOIN pc.web_contrato_montantes AS cm ON ce.id_montantes = cm.id where ce.id_cliente = (SELECT cliente_id FROM pc.web_unidades where id_unidades = :id_unidades)", nativeQuery=true)
	List<ContratoEnergia2> listandoContratosEnergia2( @Param("id_unidades") Integer id_unidades);
}
