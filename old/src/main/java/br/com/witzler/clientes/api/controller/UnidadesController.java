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
import br.com.witzler.clientes.domain.dto.UnidadesDTO;
import br.com.witzler.clientes.domain.entity.Unidades;
import br.com.witzler.clientes.domain.repositorio.UnidadesRepositorio;
import br.com.witzler.clientes.security.jwt.JwtSecurityValidateToken;

@RestController
@RequestMapping("/api/")
public class UnidadesController {
	
	@Autowired
	UnidadesRepositorio unidadesRepositorio;
	
	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;
	
	@GetMapping("unidades")
	public List<Unidades> listaUnidades() {
		/*VALIDAÇÃO TOKEN PELO CLIENT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		/*FIM VALIDAÇÃO TOKEN PELO CLIENT ID*/
		return unidadesRepositorio.listandoUnidadesCliente(decriptToken.getUsername());
	}
	
	@GetMapping("unidadesNome")
	public List<Unidades> listaUnidadesNome() {
		/*VALIDAÇÃO TOKEN PELO CLIENT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		/*FIM VALIDAÇÃO TOKEN PELO CLIENT ID*/
		return unidadesRepositorio.listandoUnidadesCliente(decriptToken.getUsername());
	}
	
	@GetMapping("unidades/cliente")
	ArrayList<UnidadesDTO> listaUnidadesCliente( 
							@RequestParam("username") String username) {
		
		//System.out.println("Username: " + username);
		//System.out.println("U_Password: " + u_password);
		List<Unidades> unidades = new ArrayList<>();
		/*VALIDAÇÃO TOKEN PELO CLIENT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		/*FIM VALIDAÇÃO TOKEN PELO CLIENT ID*/
		if(decriptToken.getUsername().contains(username)) {
			unidades = unidadesRepositorio.listandoUnidadesCliente(username);
		}
		
		//System.out.println("resultados: " + unidades);
		
		ArrayList<UnidadesDTO> ConjuntoUnidades = new ArrayList<>();
		for (int i=0; i<unidades.size(); i++)
		{
			UnidadesDTO udto = new UnidadesDTO();
			udto.setNome(unidades.get(i).getNome());
			udto.setId_unidades(unidades.get(i).getId_unidades());
			udto.setCliente_id(unidades.get(i).getCliente_id());
			udto.setMedidor(unidades.get(i).getMedidor());
			udto.setDistribuidora(unidades.get(i).getDistribuidora());
			udto.setUc_unidade(unidades.get(i).getUc_unidade());
			
			ConjuntoUnidades.add(udto);
		}
		
		
		return ConjuntoUnidades;
		
	}
	
	
	
	
		
}
