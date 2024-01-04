package br.com.witzler.clientes.api.controller;

import java.time.LocalDate;
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

import br.com.witzler.clientes.domain.repositorio.DemandaRepositorio;
import br.com.witzler.clientes.domain.repositorio.UnidadesRepositorio;
import br.com.witzler.clientes.security.jwt.JwtSecurityValidateToken;
import br.com.witzler.clientes.domain.dto.DemandaDTO;
import br.com.witzler.clientes.domain.entity.Demanda;

@RestController
@RequestMapping("/api/demanda")
public class DemandaController {
	
	@Autowired
	private UnidadesRepositorio unidadesRepositorio;

	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;

	private DemandaRepositorio demandaRepositorio;

	public DemandaController(DemandaRepositorio demandaRepositorio) {
		this.demandaRepositorio = demandaRepositorio;
	}

	@GetMapping("data_unidade")
	List<Demanda> listaDemanda(@RequestParam("unidade_id") Integer unidade_id,
			@RequestParam("mes_ref") @DateTimeFormat(pattern = "yyyy-MM-dd") Date mes_ref) {
		
		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		List<Demanda> demandaDataUnidade = new ArrayList<>();
		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, unidade_id)) {
			demandaDataUnidade = demandaRepositorio.listandoDemanda(unidade_id, mes_ref); // REQUEST
		}
		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		
		return demandaDataUnidade;
	}
	
	@GetMapping("periodo")
	ArrayList<DemandaDTO> dadosDemanda(
			@RequestParam("unidade_id") Integer unidade_id,
			@RequestParam("dataInicial") String dataInicial,
			@RequestParam("dataFinal") String dataFinal) {
		String[] datai = dataInicial.split("-");
		String[] dataf = dataFinal.split("-");
		Date dataIni = new Date((Integer.valueOf(datai[0])-1900),
				Integer.valueOf(datai[1])-1,
				Integer.valueOf(datai[2]));
		Date dataFin = new Date((Integer.valueOf(dataf[0])-1900),
				Integer.valueOf(dataf[1])-1,
				Integer.valueOf(dataf[2]));
		
		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		List<Demanda> demandas = new ArrayList<>();
		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, unidade_id)) {
			demandas = demandaRepositorio.listaDemandaPrazo(unidade_id, dataIni, dataFin); // REQUEST
		}
		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		
		
		ArrayList<DemandaDTO> ConjuntoDemanda = new ArrayList<>();
		for(int i = 0; i < demandas.size(); i++) {
			DemandaDTO demandaOne = new DemandaDTO();
			demandaOne.setMes_ref(demandas.get(i).getMes_ref());
			demandaOne.setC_demanda_fponta(demandas.get(i).getC_demanda_fponta());
			demandaOne.setC_demanda_ponta(demandas.get(i).getC_demanda_ponta());
			demandaOne.setDemanda_fponta(demandas.get(i).getDemanda_fponta());
			demandaOne.setDemanda_ponta(demandas.get(i).getDemanda_ponta());
			
			ConjuntoDemanda.add(demandaOne);
		}
		
		return ConjuntoDemanda;
	}
}
