package br.com.witzler.clientes.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.dto.MedidasForaPontaDTO;
import br.com.witzler.clientes.domain.dto.MedidasForaPontaDiarioDTO;
import br.com.witzler.clientes.domain.dto.PerformanceUnidadesDTO;
import br.com.witzler.clientes.domain.entity.Bandeiras;
import br.com.witzler.clientes.domain.entity.Medidas;
import br.com.witzler.clientes.domain.entity.PerformanceUnidades;
import br.com.witzler.clientes.domain.repositorio.BandeirasRepositorio;
import br.com.witzler.clientes.domain.repositorio.PerformanceUnidadesRepositorio;
import br.com.witzler.clientes.domain.repositorio.UnidadesRepositorio;
import br.com.witzler.clientes.security.jwt.JwtSecurityValidateToken;

@RestController
@RequestMapping("/api/")
public class PerformanceUnidadesController {
	
	@Autowired
	private PerformanceUnidadesRepositorio performanceUnidadesRepositorio;
	
	@Autowired
	private UnidadesRepositorio unidadesRepositorio;

	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;
	
	
	/*
	 * Método que retorna as economias dos últimos 13 Meses (Histórico de Economia Consolidado: ACL X ACR)
	 * 03/06/2020
	 * TI Witzler Team
	 * Status: OK
	 * */

	@GetMapping("economia/ultimos13Meses")
	List<PerformanceUnidades> listaEconomias13MesesIdUnidade( @RequestParam("id_unidade") Integer id_unidade ) {
	
		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		List<PerformanceUnidades> performanceUnidades = new ArrayList<>();
		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, id_unidade)) {
			performanceUnidades = performanceUnidadesRepositorio.listandoEconomia13Meses(id_unidade); // REQUEST
		}
		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/

		//System.out.println("Isso é o que está chegando: " + performanceUnidades);
		
		// ArrayList<PerformanceUnidadesDTO> ConjuntoPerformance = new ArrayList<>();
	
		
		return performanceUnidades;	
	}
	
	
	
	
	/*
	 * Métodos que retorna lista de economias das unidades do cliente
	 * 03/06/2020
	 * TI Witzler Team
	 * Status: OK
	 * */
	
	@GetMapping("listando/economias/cliente")
	List<PerformanceUnidades> listaEconomiasCliente( @RequestParam("username") String username) {
		
		List<PerformanceUnidades> performanceUnidades = new ArrayList<>();
		/*VALIDAÇÃO TOKEN PELO CLIENT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		if(username.contains(decriptToken.getUsername())) {
			performanceUnidades = performanceUnidadesRepositorio.listandoEconomiaTotalCliente(decriptToken.getUsername());
		}
		/*FIM VALIDAÇÃO TOKEN PELO CLIENT ID*/

		//System.out.println("Valores: " + performanceUnidades);
		
		double somando = 0;
		
		for( int i=0; i<performanceUnidades.size(); i++) {
			somando = somando + performanceUnidades.get(i).getValor_economizado();
			
		}
		System.out.println("Essa é a soma: "+somando);
		
		//ArrayList<PerformanceUnidadesDTO> ConjuntoPerformance = new ArrayList<>();
		
		//System.out.println("Economia: " + ConjuntoPerformance.get(i));
		
		return performanceUnidades;			
		
	}
	
	
	
	
	
	@GetMapping("listando/economias/unidade")
	List<PerformanceUnidades> listaEconomiasUnidade( @RequestParam("id_unidades") Integer id_unidades) {
		
		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		List<PerformanceUnidades> performanceUnidades = new ArrayList<>();
		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, id_unidades)) {
			performanceUnidades = performanceUnidadesRepositorio.listandoEconomiaTotalUnidade(id_unidades); // REQUEST
		}
		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/

		//System.out.println("Valores: " + performanceUnidades);
		
		double somando = 0;
		
		for( int i=0; i<performanceUnidades.size(); i++) {
			somando = somando + performanceUnidades.get(i).getValor_economizado();
			
		}
		System.out.println("Essa é a soma: "+somando);
		
		//ArrayList<PerformanceUnidadesDTO> ConjuntoPerformance = new ArrayList<>();
		
		//System.out.println("Economia: " + ConjuntoPerformance.get(i));
		
		return performanceUnidades;			
		
	}
	
	
	
	

	
	/*
	 *  Método que retorna o total de economia do cliente
	 *  Status: OK
	 * */
	/*
	@GetMapping("total/economia/cliente")
	double listaValorTotalCliente( @RequestParam("id_unidades") Integer id_unidades ) {

		List<PerformanceUnidades> performanceUnidades = performanceUnidadesRepositorio.listandoEconomiaTotalCliente(id_unidades);
		
		System.out.println("Valores: " + performanceUnidades);
		
		PerformanceUnidadesDTO pudto = new PerformanceUnidadesDTO();
		
		double somando = 0;
		
		for (int i=0; i<performanceUnidades.size(); i++)
		{
			somando = somando + performanceUnidades.get(i).getValor_economizado();
	
		}
		
		System.out.println("Soma: " + somando);
		
		return somando;
		
	}
*/
	

}
