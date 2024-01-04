package br.com.witzler.clientes.api.controller;

import br.com.witzler.clientes.domain.dto.ArquivosUnidadeDTO;
import br.com.witzler.clientes.domain.dto.ArquivosUnidadeDatasDTO;
import br.com.witzler.clientes.domain.dto.ArquivosUnidadeTipoDTO;
import br.com.witzler.clientes.domain.entity.ArquivosUnidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.repositorio.ArquivosUnidadeRepositorio;
import br.com.witzler.clientes.domain.repositorio.UnidadesRepositorio;
import br.com.witzler.clientes.security.jwt.JwtSecurityValidateToken;

@RestController
@RequestMapping("/api/")
public class ArquivosUnidadeController {
	
	@Autowired
	private ArquivosUnidadeRepositorio arquivosUnidadeRepositorio;
	
	@Autowired
	private UnidadesRepositorio unidadesRepositorio;

	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;
	
	/*
	 * Método que lista todos os pdfs de uma unidade
	 * 
	 * */
//	@GetMapping("arquivos/unidade")
//	List<ArquivosUnidade> listaArquivosUnidade( @RequestParam("unidade_id") Integer unidade_id, 
//												@RequestParam("data_referencia") @DateTimeFormat(pattern = "yyyy-MM-dd") Date data_referencia,
//												@RequestParam("tipo_arquivo") Integer tipo_arquivo) {
//		
//		System.out.println("Essa é a data de referencia: "+data_referencia);
//		System.out.println("Essa é a unidade_id: "+unidade_id);
//		System.out.println("Esse é o tipo de arquivo: "+tipo_arquivo);
//		
//		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
//		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
//		List<ArquivosUnidade> arquivosUnidade = new ArrayList<>();
//		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, unidade_id)) {
//			arquivosUnidade = arquivosUnidadeRepositorio.listandoArquivosUnidade(unidade_id, data_referencia, tipo_arquivo); // REQUEST
//		}
//		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/
//		
//		System.out.println("resultados: " + arquivosUnidade);
//		
//		ArrayList<ArquivosUnidadeTipoDTO> ConjuntoArquivosUnidade = new ArrayList<>();
//		
//		return arquivosUnidade;
//
//	}
//	
	
	
	
	/*
	 * Método que lista todos os tipos de arquivo da unidade
	 * 
	 * */
	@GetMapping("tipos/arquivos/unidade")
	ArrayList<ArquivosUnidadeTipoDTO> listaTiposArquivosUnidade( 
			@RequestParam("unidade_id") Integer unidade_id ) {
		
		// System.out.println("Essa é a unidade_id: "+unidade_id);
		
		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		List<ArquivosUnidade> arquivosUnidade = new ArrayList<>();
		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, unidade_id)) {
			arquivosUnidade = arquivosUnidadeRepositorio.listandoTiposArquivosUnidade(unidade_id);
		}
		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		
		ArrayList<ArquivosUnidadeTipoDTO> ConjuntoTipos = new ArrayList<>();
		for (int i = 0; i<arquivosUnidade.size(); i++)
		{
			boolean repetido = false;
			for (int j=0; j<ConjuntoTipos.size(); j++) {
				if (arquivosUnidade.get(i).getTipo_arquivo().equals(ConjuntoTipos.get(j).getTipo_arquivo())) {
					repetido = true;
				}
			}
				if(!repetido) {
					ArquivosUnidadeTipoDTO audto = new ArquivosUnidadeTipoDTO();
					audto.setTipo_arquivo(arquivosUnidade.get(i).getTipo_arquivo());
					audto.setTipo_arquivo_descricao(arquivosUnidade.get(i).getTipo_arquivo_descricao());
					ConjuntoTipos.add(audto);
					//ConjuntoTipos.get(i).getTipo_arquivo();
				}
		}
		
		// System.out.println("jjjjjjjjjjjj: "+ConjuntoTipos.size());

	
		return ConjuntoTipos;
		
	}
	/*
	 * Lista as datas dos arquivos de uma unidade
	 * 
	 * 
	 */
	@GetMapping("datas/arquivos/unidade")
	ArrayList<ArquivosUnidadeDatasDTO> listaDatasArquivosUnidade( @RequestParam("unidade_id") Integer unidade_id ) {
		
		// System.out.println("Essa é a unidade_id: "+unidade_id);
		
		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		List<ArquivosUnidade> datasArquivosUnidade = new ArrayList<>();
		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, unidade_id)) {
			datasArquivosUnidade = arquivosUnidadeRepositorio.listandoDatasArquivosUnidade(unidade_id);
		}
		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		
		System.out.println("resultados: " + datasArquivosUnidade);
		
		
		ArrayList<ArquivosUnidadeDatasDTO> ConjuntoDatas = new ArrayList<>();
		for (int i=0; i<datasArquivosUnidade.size(); i++)
		{
			ArquivosUnidadeDatasDTO datas = new ArquivosUnidadeDatasDTO();
			datas.setData_referencia(datasArquivosUnidade.get(i).getData_referencia());
			ConjuntoDatas.add(datas);
		}
		
		return ConjuntoDatas;
	}

}
