package br.com.witzler.clientes.api.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.dto.WebPreviaDTO;
import br.com.witzler.clientes.domain.entity.WebPrevia;
import br.com.witzler.clientes.domain.repositorio.UnidadesRepositorio;
import br.com.witzler.clientes.domain.repositorio.WebPreviaRepositorio;
import br.com.witzler.clientes.security.jwt.JwtSecurityValidateToken;

@RestController
@RequestMapping("/api/")
public class WebPreviaController {
	
	@Autowired
	private WebPreviaRepositorio webpreviaRepositorio;
	
	@Autowired
	private UnidadesRepositorio unidadesRepositorio;
	
	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;
	
	@GetMapping("webprevia")
	ArrayList<WebPreviaDTO> listaPrevia(
			@RequestParam("unidade_id") Integer unidade_id,
			@RequestParam("data_previa") String data_previa) {
		
		//Realizando tratamento da data_previa
		String[] dataP = data_previa.split("-");
		Date datap = new Date((Integer.valueOf(dataP[0])-1900),
				Integer.valueOf(dataP[1])-1,
				Integer.valueOf(dataP[2]));
		
		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		List<WebPrevia> webprevia = new ArrayList<>();
		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, unidade_id)) {
			webprevia = webpreviaRepositorio.listarPrevias(unidade_id, datap); // REQUEST
		}
		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		
		// System.out.println(webprevia);

		ArrayList<WebPreviaDTO> ConjuntoWebPrevia = new ArrayList<>();
		
		for (int i=0; i<webprevia.size(); i++)
		{
			WebPreviaDTO wp = new WebPreviaDTO();
			wp.setId(webprevia.get(i).getId());
			wp.setData_previa(webprevia.get(i).getData_previa());
			wp.setMax_c(webprevia.get(i).getMax_c());
			wp.setMin_c(webprevia.get(i).getMin_c());
			wp.setContratado(webprevia.get(i).getContratado());
			wp.setConsumido(webprevia.get(i).getConsumido());
			wp.setUnidade_id(webprevia.get(i).getUnidade_id());
			wp.setConsumo_medido(webprevia.get(i).getConsumo_medido());
			
			ConjuntoWebPrevia.add(wp);
			
		}
		
		return ConjuntoWebPrevia;
		
	}

}
