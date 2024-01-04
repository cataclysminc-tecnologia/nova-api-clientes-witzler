package br.com.witzler.clientes.domain.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.witzler.clientes.domain.entity.Arquivos;
import br.com.witzler.clientes.domain.entity.ArquivosCliente;

public interface ArquivosRepositorio extends JpaRepository<Arquivos, Integer> {
	
	/*
	 * Query que lista todos os caminhos dos pdfs do cliente
	 * */
	@Query(value="SELECT * FROM pc.web_arquivos AU INNER JOIN (pc.web_cliente WC INNER JOIN ( pc.web_login_cliente WLC INNER JOIN pc.web_login WL ON WLC.login_id = WL.id_login)  ON WLC.client_id = WC.id_cliente) ON WC.cow_client_id = AU.cow_client_id WHERE WC.id_cliente = (SELECT cliente_id FROM pc.web_unidades WHERE id_unidades = :unidade_id) AND AU.tipo_arquivo = :tipo_arquivo AND  AU.data_referencia = :data_referencia", nativeQuery=true)
	List<Arquivos> listandoArquivos( @Param("unidade_id") Integer unidade_id, @Param("data_referencia") @DateTimeFormat(pattern = "yyyy-MM-dd") Date data_referencia, @Param("tipo_arquivo") Integer tipo_arquivo );
	
	
	
	/*
	 * Query que lista todos os tipos de arquivos do cliente
	 * 
	 * */
	@Query(value="SELECT * FROM pc.web_arquivos AU INNER JOIN (pc.web_cliente WC INNER JOIN ( pc.web_login_cliente WLC INNER JOIN pc.web_login WL ON WLC.login_id = WL.id_login)  ON WLC.client_id = WC.id_cliente) ON WC.cow_client_id = AU.cow_client_id WHERE WC.id_cliente = (SELECT cliente_id FROM pc.web_unidades WHERE id_unidades = :unidade_id)", nativeQuery=true)
	List<Arquivos> listandoTiposArquivos( @Param("unidade_id") Integer unidade_id );
	
	
	
	
	/*
	 * Query que lista todas as datas dos arquivos pdfs do cliente
	 * */
	@Query(value="SELECT DISTINCT(AU.data_referencia) FROM pc.web_arquivos AU INNER JOIN (pc.web_cliente WC INNER JOIN ( pc.web_login_cliente WLC INNER JOIN pc.web_login WL ON WLC.login_id = WL.id_login)  ON WLC.client_id = WC.id_cliente) ON WC.cow_client_id = AU.cow_client_id WHERE WC.id_cliente = (SELECT cliente_id FROM pc.web_unidades WHERE id_unidades = :unidade_id)", nativeQuery=true)
	List<Arquivos> listandoDatasArquivos( @Param("unidade_id") Integer unidade_id );
	
	
	
	
	//@Query(value="SELECT * FROM pc.web_arquivos WHERE data_referencia = :data_referencia AND tipo_arquivo = 3 AND cow_unit_id = (SELECT cow_unit_id FROM pc.web_unidades WHERE id_unidades = :id_unidades);", nativeQuery=true)
	@Query(value="SELECT * FROM pc.web_arquivos WHERE data_referencia = :data_referencia AND tipo_arquivo = 3 AND cow_client_id = (SELECT cow_client_id FROM pc.web_cliente WHERE id_cliente = (SELECT cliente_id FROM pc.web_unidades WHERE id_unidades = :id_unidades));", nativeQuery=true)
	List<Arquivos> listandoCaminhoArquivosRelatorios( @Param("id_unidades") Integer id_unidades,
													  @Param("data_referencia") Date data_referencia);

}
