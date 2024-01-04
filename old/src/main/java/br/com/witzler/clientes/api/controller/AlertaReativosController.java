package br.com.witzler.clientes.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.dto.AlertaReativosDTO;
import br.com.witzler.clientes.domain.entity.AlertaReativos;
import br.com.witzler.clientes.domain.repositorio.AlertaReativosRepositorio;
import br.com.witzler.clientes.security.jwt.JwtSecurityValidateToken;

@RestController
@RequestMapping("/api/")
public class AlertaReativosController {
	
	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;

	@Autowired
	AlertaReativosRepositorio alertaReativosRepositorio;
	
	@GetMapping("consulta/alerta/reativos")
	ArrayList<AlertaReativosDTO> listaAlertaReativos(
								@RequestParam("cliente_id") Integer cliente_id
								) {
		
		System.out.println("Cliente_id: " + cliente_id);

		/*VALIDAÇÃO TOKEN PELO CLIENT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		if(decriptToken.getId_client().intValue() != cliente_id.intValue()) { // BLOQUEAR DADOS DE OUTROS CLIENTES
			return null;
		}
		/*FIM VALIDAÇÃO TOKEN PELO CLIENT ID*/
		
		List<AlertaReativos> areativos = alertaReativosRepositorio.listandoAlertaReativos(cliente_id);
		System.out.println("resultados: " + areativos);
		
		ArrayList<AlertaReativosDTO> ConjuntoReativos = new ArrayList<>();
		for (int i=0; i<areativos.size(); i++)
		{
			AlertaReativosDTO ardto = new AlertaReativosDTO();
			ardto.setAlertar_com(areativos.get(i).getAlertar_com());
			ardto.setIntervalo(areativos.get(i).getIntervalo());
			ConjuntoReativos.add(ardto);
		}
		
		return ConjuntoReativos;
		
	}
	
	
	@PutMapping("atualiza/alerta/reativos")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void atualizarReativo( @RequestParam("alertar_com") double alertarcom, 
								  @RequestParam("intervalo") double intervalo,
								  @RequestParam("id_unidade") Integer id_unidade) {
		
		
		
	}
	
	
}
