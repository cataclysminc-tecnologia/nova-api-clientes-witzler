package br.com.witzler.clientes.security.jwt;

import java.util.Date;
import java.util.HashMap;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import br.com.witzler.clientes.ClientesApplication;
import br.com.witzler.clientes.domain.entity.Usuario;
import br.com.witzler.clientes.domain.entity.UsuariosColaboradores;
import br.com.witzler.clientes.domain.entity.WebLogin;
import br.com.witzler.clientes.domain.entity.WebLoginCliente;
import br.com.witzler.clientes.domain.repositorio.WebLoginClienteRepositorio;
import br.com.witzler.clientes.domain.repositorio.WebLoginRepositorio;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {
	
	@Autowired
	private WebLoginRepositorio webLoginRepositorio;
	@Autowired
	private WebLoginClienteRepositorio webLoginClienteRepositorio;
	
	@Value("${security.jwt.expiracao}")
	private String expiracao;
	
	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;
	
	private Integer id_client_logado = 0;
	
	public String gerarToken( Usuario usuario ) {
		long expString = Long.valueOf(expiracao);
		LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(expString);
		Instant instant = dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant();
		Date data = Date.from(instant);
		
		/*PEGANDO ID CLIENTE SE EXISTIR PARA SER COLOCADO NO TOKEN*/
		WebLogin login = webLoginRepositorio.listarWebLoginPorUsername(usuario.getUsername());
		WebLoginCliente login_cliente = webLoginClienteRepositorio.listarWebLoginClientePeloLoginId(login.getId_login());
		try {
			/*LOGIN CLIENTE PK*/
			System.out.println(login_cliente.getClient_id());	
		}catch(Exception ex) {
			/*## NÃO FOI ENCONTRADO NENHUM CLIENTE COM ESSE ID LOGIN, PROVAVELMENTE ESTE USUÁRIO É SOMENTE UM USUÁRIO PARA AUTENTICAÇÃO ##*/
			login_cliente = new WebLoginCliente();
			login_cliente.setClient_id(0);
		}
		this.id_client_logado = login_cliente.getClient_id();
		/*FIM PEGANDO ID CLIENTE SE EXISTIR PARA SER COLOCADO NO TOKEN*/
		return Jwts
				.builder()
				.setSubject(usuario.getUsername())
				.claim("id_cliente", this.id_client_logado)
				.setExpiration(data)
				.signWith( SignatureAlgorithm.HS512, chaveAssinatura )
				.compact();
	}
	
	public String gerarTokenColaborador( UsuariosColaboradores usuario ) {
		long expString = Long.valueOf(expiracao);
		LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(expString);
		Instant instant = dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant();
		Date data = Date.from(instant);

		
		return Jwts
				.builder()
				.setSubject(usuario.getUsername())
				.claim("id_cliente", this.id_client_logado)
				.setExpiration(data)
				.signWith( SignatureAlgorithm.HS512, chaveAssinatura )
				.compact();
	}
	
	
	private Claims obterClaims(String token ) throws ExpiredJwtException {
		return Jwts
					.parser()
					.setSigningKey(chaveAssinatura)
					.parseClaimsJws(token)
					.getBody();
	}
	
	
	public boolean tokenValid( String token ) {
		try {
			Claims claims = obterClaims(token);
			Date dataExpiracao = claims.getExpiration();
			LocalDateTime data = 
					dataExpiracao.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			return !LocalDateTime.now().isAfter(data);
		}catch (Exception e) {
			return false;
		}
	}
	
	public String obterLoginUsuario(String token) throws ExpiredJwtException {
		return (String) obterClaims(token).getSubject();
	}
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext contexto = SpringApplication.run(ClientesApplication.class, args);
		JwtService service = contexto.getBean(JwtService.class);
//		Usuario usuario = Usuario.builder().username("franciny").build();
//		String token = service.gerarToken(usuario);
//		System.out.println(token);
//		
//		boolean isTokenValido = service.tokenValid(token);
//		System.out.println("O token está válido? " + isTokenValido);
//		
//		System.out.println(service.obterLoginUsuario(token));
	}

}
