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

import br.com.witzler.clientes.domain.dto.MedidasPeriodoFatorPotenciaHoraDTO;
import br.com.witzler.clientes.domain.entity.Medidas2;
import br.com.witzler.clientes.domain.repositorio.Medidas2Repositorio;
import br.com.witzler.clientes.domain.repositorio.UnidadesRepositorio;
import br.com.witzler.clientes.security.jwt.JwtSecurityValidateToken;

@RestController
@RequestMapping("/api/")
public class Medidas2Controller {
	
	@Autowired
	private Medidas2Repositorio medidas2Repositorio;
	
	@Autowired
	private UnidadesRepositorio unidadesRepositorio;

	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;
	
	// Método que lista fatorPotênciaHora
		@GetMapping("/periodo/fator/potencia/hora")
		ArrayList<MedidasPeriodoFatorPotenciaHoraDTO> listaMedidasPeriodoFatorPotenciaHora(
				@RequestParam("unidade_id") Integer unidade_id,
				@RequestParam("data_busca") String data_busca){
			
			
			String[] dataB = data_busca.split("-");
			Date datab = new Date((Integer.valueOf(dataB[0])-1900),
					Integer.valueOf(dataB[1])-1,
					Integer.valueOf(dataB[2]));
			
			/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
			JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
			List<Medidas2> medidas2 = new ArrayList<>();
			if(decriptToken.isUnidadeFromClient(unidadesRepositorio, unidade_id)) {
				medidas2 = medidas2Repositorio.listarFatorPotenciaHora(unidade_id, datab); // REQUEST
			}
			/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/
			
			// System.out.println(medidas2);
			
			
			
			ArrayList<MedidasPeriodoFatorPotenciaHoraDTO> ConjuntoFatorPotenciaHora = new ArrayList<>();
			
			for (int i=0; i<medidas2.size(); i++)
			{

				MedidasPeriodoFatorPotenciaHoraDTO mfph = new MedidasPeriodoFatorPotenciaHoraDTO();

				mfph.setCapacitivo(medidas2.get(i).getCapacitivo());
				mfph.setHora_do_dia(medidas2.get(i).getHora_do_dia());
				ConjuntoFatorPotenciaHora.add(mfph);
				
			}
			
			
			return ConjuntoFatorPotenciaHora;
			
		}

}
