package br.com.witzler.clientes.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.dto.UnidadesContratosDTO;
import br.com.witzler.clientes.domain.entity.Unidades;
import br.com.witzler.clientes.domain.entity.UnidadesContratos;
import br.com.witzler.clientes.domain.repositorio.UnidadesContratosRepositorio;
import br.com.witzler.clientes.domain.repositorio.UnidadesRepositorio;
import br.com.witzler.clientes.security.jwt.JwtSecurityValidateToken;

@RestController
@RequestMapping("/api/")
public class UnidadesContratosController {
	
	@Autowired
	UnidadesContratosRepositorio repositorio;
	
	@Autowired
	private UnidadesRepositorio unidadesRepositorio;

	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;
	
	/*
	 * Método que lista todos os contratos de uma unidade
	 * */
	@GetMapping("unidades/contratos")
	ArrayList<UnidadesContratosDTO> listaContratosUnidades( @RequestParam("id_unidades") Integer id_unidades ) {
	
		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		List<UnidadesContratos> unidadescontratos = new ArrayList<>();
		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, id_unidades)) {
			unidadescontratos = repositorio.listandoContratosUnidade(id_unidades); // REQUEST
		}
		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		
		ArrayList<UnidadesContratosDTO> ConjuntoUnidadesContratos = new ArrayList<>();
		
		for (int i=0; i<unidadescontratos.size(); i++)
		{
			UnidadesContratosDTO ucdto = new UnidadesContratosDTO();
			ucdto.setNome_unidade(unidadescontratos.get(i).getNome_unidade());
			ucdto.setComercializadora_id(unidadescontratos.get(i).getComercializadora_id());
			ucdto.setInicio_suprimento(unidadescontratos.get(i).getInicio_suprimento());
			ucdto.setFim_suprimento(unidadescontratos.get(i).getFim_suprimento());
			ucdto.setMontante_percentual(unidadescontratos.get(i).getMontante_percentual());
			ucdto.setE_sazo(unidadescontratos.get(i).isE_sazo());
			ucdto.setSazo_inf(unidadescontratos.get(i).getSazo_inf());
			ucdto.setSazo_sup(unidadescontratos.get(i).getSazo_sup());
			ucdto.setE_flex(unidadescontratos.get(i).isE_flex());
			ucdto.setFlex_inf(unidadescontratos.get(i).getFlex_inf());
			ucdto.setFlex_sup(unidadescontratos.get(i).getFlex_sup());
			ucdto.setMontante(unidadescontratos.get(i).getMontante());
			ucdto.setNome(unidadescontratos.get(i).getNome());
			ucdto.setPath(unidadescontratos.get(i).getPath());
			ucdto.setNumero_contrato(unidadescontratos.get(i).getNumero_contrato());
			
			ConjuntoUnidadesContratos.add(ucdto);
		}
		
		
		
		
		return ConjuntoUnidadesContratos;
		
	}

}
