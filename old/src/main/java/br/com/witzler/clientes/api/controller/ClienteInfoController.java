package br.com.witzler.clientes.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.dto.ClienteInfoDTO;
import br.com.witzler.clientes.domain.entity.ClienteInfo;
import br.com.witzler.clientes.domain.repositorio.ClienteInfoRepositorio;
import br.com.witzler.clientes.domain.repositorio.UnidadesRepositorio;
import br.com.witzler.clientes.security.jwt.JwtSecurityValidateToken;

@RestController
@RequestMapping("/api/")
public class ClienteInfoController {
	
	@Autowired
	private ClienteInfoRepositorio clienteInfoRepositorio;
	
	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;

	
	// Listando toda a info do Cliente
	@GetMapping("informacaoCliente")
	ArrayList<ClienteInfoDTO> listaClienteInfo(
			@RequestParam("id_cliente") Integer id_cliente) {
		
		//System.out.println("id_cliente: " + id_cliente);
		/*VALIDAÇÃO TOKEN PELO CLIENT ID*/
		boolean executarDeFatoInfoCliente = false;
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		if(decriptToken.getId_client().intValue() == id_cliente.intValue()) { // BLOQUEAR DADOS DE OUTROS CLIENTES
			executarDeFatoInfoCliente = true;
		}
		/*FIM VALIDAÇÃO TOKEN PELO CLIENT ID*/
		
		ArrayList<ClienteInfoDTO> ConjuntoInfoCliente = new ArrayList<>();
		
		if(!executarDeFatoInfoCliente) {
			return ConjuntoInfoCliente;
		}
		
		List<ClienteInfo> clienteinfo = clienteInfoRepositorio.listarInfoCliente(id_cliente);
		

		//System.out.println("Resultados: " + clienteinfo);
		
		//System.out.println("O conjunto está vazio?" + ConjuntoInfoCliente);
		
		for (int i=0; i<clienteinfo.size(); i++)
		{
			ClienteInfoDTO cidto = new ClienteInfoDTO();
			cidto.setNome_fantasia(clienteinfo.get(i).getNome_fantasia());
			cidto.setType_client(clienteinfo.get(i).getType_client());
			ConjuntoInfoCliente.add(cidto);
		}
		
		//System.out.println("O conjunto não deveria estar vazio aqui:" + ConjuntoInfoCliente);
		
		return ConjuntoInfoCliente;
		
	}

}
