package br.com.witzler.clientes.domain.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.witzler.clientes.domain.entity.Unidades;
import br.com.witzler.clientes.domain.entity.UnidadesContratos;

public interface UnidadesContratosRepositorio extends JpaRepository<UnidadesContratos, Integer>{
	
	
	
	/*
	 * Query que lista todos os contratos da unidade 
	 *  
	 * */
	@Query(value="SELECT id_unidades, cliente_id, cow_unit_id, distribuidora, latitude, longitude, medidor, medidor_reserva, medidor_r_existe, perfil_agente, unidades.nome as nome_unidade,contrato_energia.comercializadora_id, contrato_energia.inicio_suprimento, contrato_energia.fim_suprimento,contrato_energia.montante_percentual,contrato_energia.e_sazo, contrato_energia.sazo_inf,contrato_energia.sazo_sup ,contrato_energia.e_flex,contrato_energia.flex_inf, contrato_energia.flex_sup, contrato_energia.montante AS montante,comercializadora.nome, comercializadora.path,contrato_energia.numero_contrato, contrato_energia.preco_base FROM pc.web_unidades AS unidades inner join pc.web_contrato_unidade on cow_unit_id =  cow_unit inner join pc.web_contrato_energia AS contrato_energia on cow_contract_son = cow_contract_son_id inner join pc.web_comercializadora  AS comercializadora on cow_id = comercializadora_id where id_unidades= :id_unidades order by contrato_energia.inicio_suprimento asc", nativeQuery=true)
	List<UnidadesContratos> listandoContratosUnidade(Integer id_unidades);

}
