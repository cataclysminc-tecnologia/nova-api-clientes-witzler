package br.com.witzler.clientes.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.entity.Usuario;
import br.com.witzler.clientes.domain.entity.UsuariosColaboradores;
import br.com.witzler.clientes.domain.entity.WebCliente;
import br.com.witzler.clientes.domain.repositorio.UsuariosColaboradoresRepository;
import br.com.witzler.clientes.domain.repositorio.WebClienteRepositorio;
import br.com.witzler.clientes.security.jwt.JwtSecurityValidateToken;
import br.com.witzler.clientes.security.jwt.JwtService;
import br.com.witzler.clientes.service.impl.UsuariosColaboradoresServiceImpl;
import br.com.witzler.clientes.service.impl.WebClienteServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/webcliente")
@RequiredArgsConstructor
public class WebClienteController {
	
	@Autowired
	private WebClienteRepositorio webClienteRepositorio;
	
	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;
	
	private final WebClienteServiceImpl usuarioService;
	private final WebClienteRepositorio repository;
	
//	@GetMapping("/info/clientes-colaborador/{colaborador_tec_id}")
//	public List<WebCliente> listaClientesUsuario(@PathVariable int colaborador_tec_id) {
//		List<WebCliente> usuario = new ArrayList<>();
//		/*VALIDAÇÃO DE ADMIN*/
//		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
//		if(decriptToken.isAdmin()) {
//			usuario = usuarioService.listandoClientesUsuarioColaborador(colaborador_tec_id);    //listandoTudoClientes(colaborador_tec_id);
//		}
//		/*FIM VALIDAÇÃO DE ADMIN*/
//		return usuario;
//	}
	
	@GetMapping("/info/clientes-colaborador/admin/")
	public List<WebCliente> listaClientesUsuarioAdmin() {
		List<WebCliente> usuario = new ArrayList<>();
		/*VERIFICAR SE ADMIN*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		if(decriptToken.isAdmin()) {
			usuario = usuarioService.listandoTodosClientesUsuarioColaboradorAdmin();    //listandoTudoClientes(colaborador_tec_id);
		}
		/*FIM VERIFICAR SE ADMIN*/
		return usuario;
	}
	
	@GetMapping("/info/qtde-clientes-colaborador/admin/")
	public List<WebCliente> listaQtdeClientesUsuarioAdmin() {
		List<WebCliente> usuario = new ArrayList<>();
		/*VERIFICAR SE ADMIN*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		if(decriptToken.isAdmin()) {
			usuario = usuarioService.listandoTodosClientesUsuarioColaboradorAdmin(); //listandoTudoClientes(colaborador_tec_id);
		}
		/*FIM VERIFICAR SE ADMIN*/
		return usuario;
	}
	
	@GetMapping("/info/usuario-cliente/{id_cliente}")
	public List<WebCliente> listaInfoUsuarioPorId( @PathVariable int id_cliente ) {
		/*VALIDAÇÃO TOKEN PELO CLIENT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		if(decriptToken.getId_client().intValue() != id_cliente) { // BLOQUEAR DADOS DE OUTROS CLIENTES
			return null;
		}
		/*FIM VALIDAÇÃO TOKEN PELO CLIENT ID*/
		List<WebCliente> usuario = usuarioService.listandoInfoUsuarioPorId(id_cliente);
		return usuario;
	}
	
	
	

}
