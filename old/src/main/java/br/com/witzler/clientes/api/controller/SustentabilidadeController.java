package br.com.witzler.clientes.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.dto.SustentabilidadeDTO;
import br.com.witzler.clientes.domain.entity.Sustentabilidade;
import br.com.witzler.clientes.domain.repositorio.SustentabilidadeRepositorio;
import br.com.witzler.clientes.security.jwt.JwtSecurityValidateToken;

@RestController
@RequestMapping("/api/")
public class SustentabilidadeController {
	
	@Autowired
	private SustentabilidadeRepositorio sustentabilidadeRepositorio;
	
	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;
	
	@GetMapping("sustentabilidade")
	ArrayList<SustentabilidadeDTO> listaInfoSustentabilidade( 
								   @RequestParam("cliente_id") Integer cliente_id ) {
		
		List<Sustentabilidade> sustentabilidade = new ArrayList<>();
		/*VALIDAÇÃO TOKEN PELO CLIENT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		if(decriptToken.getId_client().intValue() == cliente_id.intValue()){
			sustentabilidade = sustentabilidadeRepositorio.listandoInfoSustentabilidade(cliente_id);
		}
		/*FIM VALIDAÇÃO TOKEN PELO CLIENT ID*/
		
		ArrayList<SustentabilidadeDTO> Conjunto = new ArrayList<>();
		
		for( int i=0; i<sustentabilidade.size(); i++)
		{
			SustentabilidadeDTO s = new SustentabilidadeDTO();
			s.setId(sustentabilidade.get(i).getId());
			s.setCliente_id(sustentabilidade.get(i).getCliente_id());
			s.setCo2_evitado_em_ton(sustentabilidade.get(i).getCo2_evitado_em_ton());
			s.setCampos_de_futebol(sustentabilidade.get(i).getCampos_de_futebol());
			
			Conjunto.add(s);
		}
		
		return Conjunto;
		
	}

}
