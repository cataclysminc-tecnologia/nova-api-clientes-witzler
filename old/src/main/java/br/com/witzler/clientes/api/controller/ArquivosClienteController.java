package br.com.witzler.clientes.api.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.dto.ArquivosClienteDatasDTO;
import br.com.witzler.clientes.domain.dto.ArquivosClienteTipoDTO;
import br.com.witzler.clientes.domain.entity.ArquivosCliente;
import br.com.witzler.clientes.domain.repositorio.ArquivosClienteRepositorio;

@RestController
@RequestMapping("/api/")
public class ArquivosClienteController {
	
	@Autowired
	private ArquivosClienteRepositorio arquivosClienteRepositorio;

	// Comentado por joao.jacomo: Essa Query não está sendo utilizada.
//	@GetMapping("arquivos/cliente")
//	List<ArquivosCliente> listaArquivosCliente( @RequestParam("unidade_id") Integer unidade_id, 
//			@RequestParam("data_referencia") @DateTimeFormat(pattern = "yyyy-MM-dd") Date data_referencia,
//			@RequestParam("tipo_arquivo") Integer tipo_arquivo ) {
//		
//		//System.out.println("Essa é a data de referencia: "+data_referencia);
//		//System.out.println("Essa é a unidade_id: "+unidade_id);
//		//System.out.println("Esse é o tipo de arquivo: "+tipo_arquivo);
//		
//		
//		List<ArquivosCliente> arquivosCliente = arquivosClienteRepositorio.listandoArquivosCliente(unidade_id, data_referencia, tipo_arquivo);
//		System.out.println("resultado: " + arquivosCliente);
//		
//		return arquivosCliente;
//		
//	}
	
	
	
	/*
	 * Método que lista todos os tipos de arquivo do cliente 
	 * Comentado por joao.jacomo: Essa Query não está sendo utilizada.
	 **/
//	@GetMapping("tipos/arquivos/cliente")
//	ArrayList<ArquivosClienteTipoDTO> listandoTiposArquivosCliente(
//								@RequestParam("unidade_id") Integer unidade_id ){
//		
//		System.out.println("Unidade_id: " + unidade_id);
//		
//		List<ArquivosCliente> arquivosCliente = arquivosClienteRepositorio.listandoTiposArquivoCliente(unidade_id);
//		
//		ArrayList<ArquivosClienteTipoDTO> ConjuntoClienteTipos = new ArrayList<>();
//		for (int i = 0; i<arquivosCliente.size(); i++)
//		{
//			boolean repetido = false;
//			for (int j=0; i<ConjuntoClienteTipos.size(); j++)
//			{
//				if (arquivosCliente.get(i).getTipo_arquivo().equals(ConjuntoClienteTipos.get(j).getTipo_arquivo())) {
//					repetido = true;
//				}
//			}
//				if(!repetido) {
//					ArquivosClienteTipoDTO actdto = new ArquivosClienteTipoDTO();
//					actdto.setTipo_arquivo(arquivosCliente.get(i).getTipo_arquivo());
//					actdto.setTipo_arquivo_descricao(arquivosCliente.get(i).getTipo_arquivo_descricao());
//					ConjuntoClienteTipos.add(actdto);
//				}
//		}
//		
//		System.out.println("Resultado dos tipos: " + ConjuntoClienteTipos.size());
//		
//		return ConjuntoClienteTipos;
//		
//	}
//	
	
	
	
	/*
	 * Método que lista as datas dos arquivos de um cliente
	 * Comentado por joao.jacomo: Essa Query não está sendo utilizada.
	 * */
//	@GetMapping("datas/arquivos/cliente")
//	ArrayList<ArquivosClienteDatasDTO> listaDatasArquivosCliente( 
//			@RequestParam("unidade_id") Integer unidade_id ) {
//		
//		
//		System.out.println("Unidade_id: " + unidade_id);
//		
//		List<ArquivosCliente> datasArquivosCliente = arquivosClienteRepositorio.listandoTiposArquivoCliente(unidade_id);
//		System.out.println("Resultados: " + datasArquivosCliente);
//		
//		ArrayList<ArquivosClienteDatasDTO> ConjuntoDatas = new ArrayList<>();
//		for (int i=0; i<datasArquivosCliente.size(); i++)
//		{
//			ArquivosClienteDatasDTO datas = new ArquivosClienteDatasDTO();
//			datas.setData_referencia(datasArquivosCliente.get(i).getData_referencia());
//			ConjuntoDatas.add(datas);
//		}
//		
//		return ConjuntoDatas;
//		
//	}
}
