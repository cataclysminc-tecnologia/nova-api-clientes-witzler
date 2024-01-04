/*
 * Repositorio para listagem de pdfs por unidade
 * 04/06/2020
 * 
 * */

package br.com.witzler.clientes.domain.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.witzler.clientes.domain.entity.ArquivosUnidade;

public interface ArquivosUnidadeRepositorio extends JpaRepository<ArquivosUnidade, Integer>{

	/*
	 * Query que lista todos os caminhos dos arquivos pdf da unidade
	 * 
	 * */
	@Query(value="SELECT * FROM pc.web_arquivos_unidade AU INNER JOIN (pc.web_unidades WU INNER JOIN (pc.web_cliente WC INNER JOIN ( pc.web_login_cliente WLC INNER JOIN pc.web_login WL ON WLC.login_id =WL.id_login)  ON WLC.client_id = WC.id_cliente) ON WU.cliente_id = WC.id_cliente) ON AU.cow_unit_id = WU.cow_unit_id WHERE WU.id_unidades = :unidade_id AND AU.data_referencia = :data_referencia AND AU.tipo_arquivo = :tipo_arquivo", nativeQuery=true)
	List<ArquivosUnidade> listandoArquivosUnidade( @Param("unidade_id") Integer unidade_id, @Param("data_referencia") @DateTimeFormat(pattern = "yyyy-MM-dd") Date data_referencia, @Param("tipo_arquivo") Integer tipo_arquivo);
	
	
	
	/*
	 *Query que lista todos os tipos de arquivos da unidade 
	 * 
	 * */
	@Query(value="SELECT DISTINCT(AU.tipo_arquivo), AU.tipo_arquivo_descricao, AU.id, AU.caminho, AU.cow_unit_id, AU.tipo_arquivo_descricao, AU.data_feito, AU.data_referencia, AU.data_processado FROM pc.web_arquivos_unidade AU INNER JOIN (pc.web_unidades WU INNER JOIN (pc.web_cliente WC INNER JOIN ( pc.web_login_cliente WLC INNER JOIN pc.web_login WL ON WLC.login_id =WL.id_login) ON WLC.client_id = WC.id_cliente) ON WU.cliente_id = WC.id_cliente) ON AU.cow_unit_id = WU.cow_unit_id WHERE WU.id_unidades = :unidade_id", nativeQuery=true)
	List<ArquivosUnidade> listandoTiposArquivosUnidade( @Param("unidade_id") Integer unidade_id );
	
	
	
	/*
	 * Query que lista todas as datas dos arquivos pdfs da unidade
	 * 
	 * */
	@Query(value="SELECT DISTINCT(AU.data_referencia), AU.tipo_arquivo_descricao, AU.id, AU.caminho, AU.cow_unit_id, AU.tipo_arquivo, AU.tipo_arquivo_descricao, AU.data_feito, AU.data_referencia, AU.data_processado FROM pc.web_arquivos_unidade AU INNER JOIN (pc.web_unidades WU INNER JOIN (pc.web_cliente WC INNER JOIN ( pc.web_login_cliente WLC INNER JOIN pc.web_login WL ON WLC.login_id =WL.id_login)  ON WLC.client_id = WC.id_cliente) ON WU.cliente_id = WC.id_cliente) ON AU.cow_unit_id = WU.cow_unit_id WHERE WU.id_unidades = :unidade_id", nativeQuery=true)
	List<ArquivosUnidade> listandoDatasArquivosUnidade( @Param("unidade_id") Integer unidade_id );
	
}
