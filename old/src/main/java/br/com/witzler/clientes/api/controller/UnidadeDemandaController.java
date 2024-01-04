package br.com.witzler.clientes.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.dto.UnidadeDemandaDTO;
import br.com.witzler.clientes.domain.entity.UnidadeDemanda;
import br.com.witzler.clientes.domain.repositorio.UnidadeDemandaRepositorio;
import br.com.witzler.clientes.domain.repositorio.UnidadesRepositorio;
import br.com.witzler.clientes.security.jwt.JwtSecurityValidateToken;

@RestController
@RequestMapping("/api/")
public class UnidadeDemandaController {
	
	@Autowired
	UnidadeDemandaRepositorio repository;
	
	@Autowired
	private UnidadesRepositorio unidadesRepositorio;

	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;
	
	@GetMapping("unidade/demanda")
	ArrayList<UnidadeDemandaDTO> listaDemanda( @RequestParam( "unidade_id" ) Integer unidade_id ) {
		
		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		List<UnidadeDemanda> demanda = new ArrayList<>();
		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, unidade_id)) {
			demanda = repository.listandoDemanda(unidade_id); // REQUEST
		}
		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		
		ArrayList<UnidadeDemandaDTO> ConjuntoDemanda = new ArrayList<>();
		
		for ( int i=0; i<demanda.size(); i++ )
		{
			UnidadeDemandaDTO u = new UnidadeDemandaDTO();
			u.setId(demanda.get(i).getId());
			u.setMes_ref(demanda.get(i).getMes_ref());
			u.setDemanda_ponta(demanda.get(i).getDemanda_ponta());
			u.setDemanda_fora_ponta(demanda.get(i).getDemanda_fora_ponta());
			u.setUnidade_id(demanda.get(i).getUnidade_id());
			
			ConjuntoDemanda.add(u);
			
		}
		
		return ConjuntoDemanda;
		
	}
	

}
