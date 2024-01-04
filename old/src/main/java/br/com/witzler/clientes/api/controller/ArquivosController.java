package br.com.witzler.clientes.api.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.dto.ArquivosClienteDatasDTO;
import br.com.witzler.clientes.domain.dto.ArquivosClienteTipoDTO;
import br.com.witzler.clientes.domain.dto.ArquivosDTO;
import br.com.witzler.clientes.domain.dto.ArquivosDatasDTO;
import br.com.witzler.clientes.domain.dto.ArquivosRelatoriosDTO;
import br.com.witzler.clientes.domain.dto.ArquivosTipoDTO;
import br.com.witzler.clientes.domain.entity.Arquivos;
import br.com.witzler.clientes.domain.entity.ArquivosCliente;
import br.com.witzler.clientes.domain.repositorio.ArquivosRepositorio;
import br.com.witzler.clientes.domain.repositorio.UnidadesRepositorio;
import br.com.witzler.clientes.security.jwt.JwtSecurityValidateToken;

@RestController
@RequestMapping("/api/")
public class ArquivosController {
	
	@Autowired
	private ArquivosRepositorio arquivosRepositorio;

	@Autowired
	private UnidadesRepositorio unidadesRepositorio;
	
	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;
	
	// Método que lista todos os arquivos
	@GetMapping("arquivos")
	List<Arquivos> listarArquivos( @RequestParam("unidade_id") Integer unidade_id, 
			@RequestParam("data_referencia") @DateTimeFormat(pattern = "yyyy-MM-dd") Date data_referencia,
			@RequestParam("tipo_arquivo") Integer tipo_arquivo ) {
		
		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		List<Arquivos> arquivos = new ArrayList<>();
		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, unidade_id)) {
			arquivos = arquivosRepositorio.listandoArquivos(unidade_id, data_referencia, tipo_arquivo); // REQUEST
		}
		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		return arquivos;
			
	}
	
	
	/*
	 * Método que lista todos os tipos de arquivo
	 * 
	 **/
	@GetMapping("tipos/arquivos/")
	ArrayList<ArquivosTipoDTO> listandoTiposArquivos(
								@RequestParam("unidade_id") Integer unidade_id ){
		
		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		List<Arquivos> arquivos = new ArrayList<>();
		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, unidade_id)) {
			arquivos = arquivosRepositorio.listandoTiposArquivos(unidade_id); // REQUEST
		}
		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		
		ArrayList<ArquivosTipoDTO> ConjuntoArquivosTipo = new ArrayList<>();
		for (int i=0; i<arquivos.size(); i++)
		{
			boolean repetido = false;
			for (int j=0; i<ConjuntoArquivosTipo.size(); j++)
			{
				if (arquivos.get(i).getTipo_arquivo().equals(ConjuntoArquivosTipo.get(j).getTipo_arquivo())) {
					repetido = true;
				}
			}
				if(!repetido) {
					ArquivosTipoDTO atdto = new ArquivosTipoDTO();
					atdto.setTipo_arquivo(arquivos.get(i).getTipo_arquivo());
					atdto.setTipo_arquivo_descricao(arquivos.get(i).getTipo_arquivo_descricao());
					ConjuntoArquivosTipo.add(atdto);
				}
		}
		
		return ConjuntoArquivosTipo;
		
	}
	
	
	
	
	/*
	 * Método que lista as datas dos arquivos
	 * 
	 * */
	@GetMapping("datas/arquivos/")
	ArrayList<ArquivosDatasDTO> listaDatasArquivos( 
			@RequestParam("unidade_id") Integer unidade_id ) {
		
		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		List<Arquivos> datasArquivos = new ArrayList<>();
		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, unidade_id)) {
			datasArquivos = arquivosRepositorio.listandoTiposArquivos(unidade_id); // REQUEST
		}
		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		
		ArrayList<ArquivosDatasDTO> ConjuntoDatas = new ArrayList<>();
		for (int i=0; i<datasArquivos.size(); i++)
		{
			ArquivosDatasDTO datas = new ArquivosDatasDTO();
			datas.setData_referencia(datasArquivos.get(i).getData_referencia());
			ConjuntoDatas.add(datas);
		}
		
		return ConjuntoDatas;
		
	}
	
	
	@GetMapping("relatorios")
	List<Arquivos> listaArquivosRelatorios( 
			@RequestParam("id_unidades") Integer id_unidades,
			@RequestParam("data_referencia") @DateTimeFormat(pattern = "yyyy-MM-dd") Date data_referencia) {
		
			/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
			JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
			List<Arquivos> arquivoRelatorio = new ArrayList<>();
			if(decriptToken.isUnidadeFromClient(unidadesRepositorio, id_unidades)) {
				arquivoRelatorio = arquivosRepositorio.listandoCaminhoArquivosRelatorios(id_unidades, data_referencia); // REQUEST
			}
			/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/
			
			return arquivoRelatorio;
	}

}
