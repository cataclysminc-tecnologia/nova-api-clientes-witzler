package br.com.witzler.clientes.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.dto.ColaboradorDTO;
import br.com.witzler.clientes.domain.entity.Colaborador;
import br.com.witzler.clientes.domain.repositorio.ColaboradorRepositorio;
import br.com.witzler.clientes.security.jwt.JwtSecurityValidateToken;

@RestController
@RequestMapping("/api/")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorRepositorio colaboradorRepositorio;
	
	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;
	
	// Lista info do atendente comercial
	@GetMapping("/atendenteComercial") //DONE
	ArrayList<ColaboradorDTO> listaAtendenteColaborador(
			@RequestParam("username") String username) {
		// System.out.println("username: " + username);
		
		/*VALIDAÇÃO TOKEN PELO NOME DE USUÁRIO DA REQUISIÇÃO*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		if(!decriptToken.isVerifiedByUsernameOrIsAdmin(username)) {
			return new ArrayList<ColaboradorDTO>();
		}
		/*FIM VALIDAÇÃO TOKEN PELO NOME DE USUÁRIO DA REQUISIÇÃO*/
		
		List<Colaborador> colaborador = colaboradorRepositorio.listarAtendenteComercial(username);
		System.out.println("Resultados: " + colaborador); // Esta listando
		
		ArrayList<ColaboradorDTO> ConjuntoColaborador = new ArrayList<>();
		System.out.println(ConjuntoColaborador);
		
		for (int i=0; i<colaborador.size(); i++)
		{
			ColaboradorDTO cdto = new ColaboradorDTO();
			System.out.println("djksdksjhdkjs: " + ConjuntoColaborador);
			cdto.setId_colaborador(colaborador.get(i).getId_colaborador());
			cdto.setNome_colaborador(colaborador.get(i).getNome_colaborador());
			cdto.setTelefone_1(colaborador.get(i).getTelefone_1());
			cdto.setTelefone_2(colaborador.get(i).getTelefone_2());
			cdto.setEmail(colaborador.get(i).getEmail());
			cdto.setPath_img(colaborador.get(i).getPath_img());
			ConjuntoColaborador.add(cdto);
		}
		
		return ConjuntoColaborador;
		
	}
	
	
	//Lista ifo do atendentede técnico
	@GetMapping("/atendenteTecnico") //DONE
	ArrayList<ColaboradorDTO> listaAtendenteTecnico(
				@RequestParam("username") String username) {
		
		// System.out.println("username: " + username);
		
		/*VALIDAÇÃO TOKEN PELO NOME DE USUÁRIO DA REQUISIÇÃO*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		if(!decriptToken.isVerifiedByUsernameOrIsAdmin(username)) {
			return new ArrayList<ColaboradorDTO>();
		}
		/*FIM VALIDAÇÃO TOKEN PELO NOME DE USUÁRIO DA REQUISIÇÃO*/
		
		
		
		List<Colaborador> colaborador = colaboradorRepositorio.listarAtendenteTecnico(username);
		System.out.println("Resultados: " + colaborador);
		
		ArrayList<ColaboradorDTO> ConjuntoColaboradorT = new ArrayList<>();
		
		for (int i=0; i<colaborador.size(); i++)
		{
			ColaboradorDTO cdto = new ColaboradorDTO();
			cdto.setId_colaborador(colaborador.get(i).getId_colaborador());
			cdto.setNome_colaborador(colaborador.get(i).getNome_colaborador());
			cdto.setTelefone_1(colaborador.get(i).getTelefone_1());
			cdto.setTelefone_2(colaborador.get(i).getTelefone_2());
			cdto.setEmail(colaborador.get(i).getEmail());
			cdto.setPath_img(colaborador.get(i).getPath_img());
			ConjuntoColaboradorT.add(cdto);
		}
		
		return ConjuntoColaboradorT;
		
	}

}
