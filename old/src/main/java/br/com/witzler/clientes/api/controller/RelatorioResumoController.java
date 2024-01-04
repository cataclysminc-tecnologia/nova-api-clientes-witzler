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

import br.com.witzler.clientes.domain.dto.RelatorioResumoDTO;
import br.com.witzler.clientes.domain.entity.RelatorioResumo;
import br.com.witzler.clientes.domain.repositorio.RelatorioResumoRepositorio;
import br.com.witzler.clientes.domain.repositorio.UnidadesRepositorio;
import br.com.witzler.clientes.security.jwt.JwtSecurityValidateToken;

@RestController
@RequestMapping("/api/")
public class RelatorioResumoController {
	
	@Autowired
	private RelatorioResumoRepositorio relatorioResumoRepositorio;
	
	@Autowired
	private UnidadesRepositorio unidadesRepositorio;

	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;
	
	@GetMapping("relatorioResumo")
	ArrayList<RelatorioResumoDTO> listaRelatorioResumo( @RequestParam("id_unid") Integer id_unid, 
											 @RequestParam("data_ref") String data_ref ) {
		
		
		String[] datai = data_ref.split("-");
		Date dataFormatada = new Date((Integer.valueOf(datai[0])-1900),
				Integer.valueOf(datai[1]) - 1,
				Integer.valueOf(datai[2]));
		
		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		List<RelatorioResumo> relatorioResumo = new ArrayList<>();
		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, id_unid)) {
			relatorioResumo = relatorioResumoRepositorio.listarRelatorio(id_unid, dataFormatada); // REQUEST
		}
		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		
		ArrayList<RelatorioResumoDTO> Conjunto = new ArrayList<>();
		
		for (int i=0; i< relatorioResumo.size(); i++)
		{
			RelatorioResumoDTO r = new RelatorioResumoDTO();
			r.setId(relatorioResumo.get(i).getId());
			r.setId_cliente(relatorioResumo.get(i).getId_cliente());
			r.setId_unid(relatorioResumo.get(i).getId_unid());
			r.setData_ref(relatorioResumo.get(i).getData_ref());
			r.setPrevia(relatorioResumo.get(i).getPrevia());
			r.setCusto_efetivo(relatorioResumo.get(i).getCusto_efetivo());
			r.setConsumo(relatorioResumo.get(i).getConsumo());
			r.setAcl_energia_contrato(relatorioResumo.get(i).getAcl_energia_contrato());
			r.setAcl_energia_cp(relatorioResumo.get(i).getAcl_energia_cp());
			r.setAcl_energia_swap(relatorioResumo.get(i).getAcl_energia_swap());
			r.setAcl_fat_dist(relatorioResumo.get(i).getAcl_fat_dist());
			r.setAcl_ccee_liq(relatorioResumo.get(i).getAcl_ccee_liq());
			r.setAcl_ccee_encargo(relatorioResumo.get(i).getAcl_ccee_encargo());
			r.setAcl_imposto(relatorioResumo.get(i).getAcl_imposto());
			r.setAcr_tusd(relatorioResumo.get(i).getAcr_tusd());
			r.setAcr_imposto(relatorioResumo.get(i).getAcr_imposto());
			r.setAcr_outros(relatorioResumo.get(i).getAcr_outros());
			r.setAcr_energia(relatorioResumo.get(i).getAcr_energia());
			
			Conjunto.add(r);
		}
		
		return Conjunto;
		
	}

}
