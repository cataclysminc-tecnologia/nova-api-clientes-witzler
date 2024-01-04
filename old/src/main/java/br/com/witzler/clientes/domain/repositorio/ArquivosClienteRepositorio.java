package br.com.witzler.clientes.domain.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.witzler.clientes.domain.entity.ArquivosCliente;

public interface ArquivosClienteRepositorio extends JpaRepository<ArquivosCliente, Integer> {

	/*
	 * Query que lista todos os caminhos dos pdfs do cliente
	 * Comentado por joao.jacomo: Essa Query não está sendo utilizada.
	 * */
//	@Query(value="SELECT * FROM pc.web_arquivos_cliente AU INNER JOIN (pc.web_cliente WC INNER JOIN ( pc.web_login_cliente WLC INNER JOIN pc.web_login WL ON WLC.login_id = WL.id_login)  ON WLC.client_id = WC.id_cliente) ON WC.cow_client_id = AU.cow_client_id WHERE WC.id_cliente = (SELECT cliente_id FROM pc.web_unidades WHERE id_unidades = :unidade_id) AND AU.tipo_arquivo = :tipo_arquivo AND  AU.data_referencia = :data_referencia", nativeQuery=true)
//	List<ArquivosCliente> listandoArquivosCliente( @Param("unidade_id") Integer unidade_id, @Param("data_referencia") @DateTimeFormat(pattern = "yyyy-MM-dd") Date data_referencia, @Param("tipo_arquivo") Integer tipo_arquivo );
	
	
	
	/*
	 * Query que lista todos os tipos de arquivos do cliente
	 * Comentado por joao.jacomo: Essa Query não está sendo utilizada.
	 * */
//	@Query(value="SELECT * FROM pc.web_arquivos_cliente AU INNER JOIN (pc.web_cliente WC INNER JOIN ( pc.web_login_cliente WLC INNER JOIN pc.web_login WL ON WLC.login_id = WL.id_login)  ON WLC.client_id = WC.id_cliente) ON WC.cow_client_id = AU.cow_client_id WHERE WC.id_cliente = (SELECT cliente_id FROM pc.web_unidades WHERE id_unidades = :unidade_id)", nativeQuery=true)
//	List<ArquivosCliente> listandoTiposArquivoCliente( @Param("unidade_id") Integer unidade_id );
	
	
	
	
	/*
	 * Query que lista todas as datas dos arquivos pdfs do cliente
	 * Comentado por joao.jacomo: Essa Query não está sendo utilizada.
	 * */
//	@Query(value="SELECT DISTINCT(AU.data_referencia) FROM pc.web_arquivos_cliente AU INNER JOIN (pc.web_cliente WC INNER JOIN ( pc.web_login_cliente WLC INNER JOIN pc.web_login WL ON WLC.login_id = WL.id_login)  ON WLC.client_id = WC.id_cliente) ON WC.cow_client_id = AU.cow_client_id WHERE WC.id_cliente = (SELECT cliente_id FROM pc.web_unidades WHERE id_unidades = :unidade_id)", nativeQuery=true)
//	List<ArquivosCliente> listandoDatasArquivosCliente( @Param("unidade_id") Integer unidade_id );
	
	
}
