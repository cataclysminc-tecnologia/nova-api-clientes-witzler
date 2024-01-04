package br.com.witzler.clientes.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.dto.RelatoriosDTO;
import br.com.witzler.clientes.domain.entity.Relatorios;
import br.com.witzler.clientes.domain.repositorio.RelatoriosRepositorio;
import br.com.witzler.clientes.domain.repositorio.UnidadesRepositorio;
import br.com.witzler.clientes.security.jwt.JwtSecurityValidateToken;

@RestController
@RequestMapping("/api/")
public class RelatoriosController {

	@Autowired
	private RelatoriosRepositorio relatoriosRepositorio;
	
	@Autowired
	private UnidadesRepositorio unidadesRepositorio;

	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;
	
//	@GetMapping("relatorios/valores")
	/*@COMENTADO POR: joao.jacomo 13/11/2023: ESSE REQUEST NÃO ESTÁ FUNCIONANDO MAS ESTÁ SENDO UTILIZADO NO PHP, ENTÃO, DEIXEI SEM COMENTAR*/
//	ArrayList<RelatoriosDTO> listaRelatorios( 
//								@RequestParam("unidade_id") Integer unidade_id,
//								@RequestParam("mes") Integer mes,
//								@RequestParam("ano") Integer ano) {
//		
//	
//		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
//		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
//		List<Relatorios> relatorios = new ArrayList<>();
//		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, unidade_id)) {
//			relatorios = relatoriosRepositorio.listandoRelatorios(unidade_id, mes, ano); // REQUEST
//		}
//		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/
//		
//		ArrayList<RelatoriosDTO> ConjuntoRelatorios = new ArrayList<>();
//		
//		for (int i=0; i<relatorios.size(); i++)
//		{
//			RelatoriosDTO rdto = new RelatoriosDTO();
//			rdto.setColuna(relatorios.get(i).getColuna());
//			rdto.setCow_unit_id(relatorios.get(i).getCow_unit_id());
//			rdto.setData_referencia(relatorios.get(i).getData_referencia());
//			rdto.setDistribuidora_id(relatorios.get(i).getDistribuidora_id());
//			rdto.setId_relatorio(relatorios.get(i).getId_relatorio());
//			rdto.setLinha(relatorios.get(i).getLinha());
//			rdto.setTarifa(relatorios.get(i).getTarifa());
//			rdto.setValor_1(relatorios.get(i).getValor_1());
//			rdto.setValor_2(relatorios.get(i).getValor_2());
//			ConjuntoRelatorios.add(rdto);
//		}
//		
//		return ConjuntoRelatorios;
//		
//		
//	}
	
	
}
