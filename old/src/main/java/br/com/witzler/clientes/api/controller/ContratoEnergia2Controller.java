package br.com.witzler.clientes.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.entity.ContratoEnergia2;
import br.com.witzler.clientes.domain.dto.ContratoEnergia2DTO;
import br.com.witzler.clientes.domain.repositorio.ContratoEnergia2Repositorio;
import br.com.witzler.clientes.domain.repositorio.UnidadesRepositorio;
import br.com.witzler.clientes.security.jwt.JwtSecurityValidateToken;

@RestController
@RequestMapping("/api/")
public class ContratoEnergia2Controller {
	
	@Autowired
	private ContratoEnergia2Repositorio contratoRepositorio;
	
	@Autowired
	private UnidadesRepositorio unidadesRepositorio;

	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;
	
	@GetMapping("contrato2")
	ArrayList<ContratoEnergia2DTO> listaContratos(
									@RequestParam("id_unidades") Integer id_unidades) {
		
		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		List<ContratoEnergia2> contratos = new ArrayList<>();
		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, id_unidades)) {
			contratos = contratoRepositorio.listandoContratosEnergia2(id_unidades); // REQUEST
		}
		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		
		ArrayList<ContratoEnergia2DTO> ConjuntoContrato = new ArrayList<>();
		
		for (int i=0; i<contratos.size(); i++)
		{
			ContratoEnergia2DTO ce = new ContratoEnergia2DTO();
			ce.setId(contratos.get(i).getId());
			ce.setId_distribuidora(contratos.get(i).getId_distribuidora());
			ce.setId_cliente(contratos.get(i).getId_cliente());
			ce.setId_montantes(contratos.get(i).getId_montantes());
			ce.setCow_id_contrato(contratos.get(i).getCow_id_contrato());
			ce.setAno(contratos.get(i).getAno());
			ce.setPreco(contratos.get(i).getPreco());
			ce.setFlex_max(contratos.get(i).getFlex_max());
			ce.setFlex_min(contratos.get(i).getFlex_min());
			ce.setE_sazo(contratos.get(i).getE_sazo());
			ce.setE_flex(contratos.get(i).getE_flex());
			ce.setSazo_max(contratos.get(i).getSazo_max());
			ce.setSazo_min(contratos.get(i).getSazo_min());
			ce.setP_carga(contratos.get(i).getP_carga());
			ce.setN_contract(contratos.get(i).getN_contract());
			ce.setV1(contratos.get(i).getV1());
			ce.setV2(contratos.get(i).getV2());
			ce.setV3(contratos.get(i).getV3());
			ce.setV4(contratos.get(i).getV4());
			ce.setV5(contratos.get(i).getV5());
			ce.setV6(contratos.get(i).getV6());
			ce.setV7(contratos.get(i).getV7());
			ce.setV8(contratos.get(i).getV8());
			ce.setV9(contratos.get(i).getV9());
			ce.setV10(contratos.get(i).getV10());
			ce.setV11(contratos.get(i).getV11());
			ce.setV12(contratos.get(i).getV12());
			
			ConjuntoContrato.add(ce);
		}
		
		return ConjuntoContrato;
		
	}
	

}
