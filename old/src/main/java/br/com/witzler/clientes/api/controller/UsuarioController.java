package br.com.witzler.clientes.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.witzler.clientes.domain.entity.Cliente;
import br.com.witzler.clientes.domain.entity.Usuario;
import br.com.witzler.clientes.domain.repositorio.Clientes;
import br.com.witzler.clientes.domain.repositorio.UsuarioRepository;
import br.com.witzler.clientes.dto.CredenciaisDTO;
import br.com.witzler.clientes.dto.TokenDTO;
import br.com.witzler.clientes.exception.SenhaInvalidaException;
import br.com.witzler.clientes.security.jwt.JwtSecurityValidateToken;
import br.com.witzler.clientes.security.jwt.JwtService;
import br.com.witzler.clientes.service.impl.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
	

	private final UsuarioServiceImpl usuarioService;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final UsuarioRepository repository;
	
	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;
	
	@PostMapping("criarUsuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario salvar(@RequestBody @Valid Usuario usuario) {
		/*VERIFICAR SE ADMIN*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		if(decriptToken.isAdmin()) {
			String senhaCriptografada = passwordEncoder.encode(usuario.getU_password());
			usuario.setU_password(senhaCriptografada);
			return usuarioService.salvar(usuario);
		}else {
			return null;
		}
		/*FIM VERIFICAR SE ADMIN*/
	}
	
	
	@PutMapping("/update/{id_login}")
	public Usuario update(@RequestBody @Valid Usuario usuario, Integer id_login) {
		String senhaCriptografada = passwordEncoder.encode(usuario.getU_password());
		usuario.setU_password(senhaCriptografada);
		return usuarioService.salvar(usuario);
	}
	
	
	/*
	@DeleteMapping("/elimina/{username}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar( @PathVariable String username ) {
		repository
			.findByUsername(username)
			.map( usuario -> {
				repository.delete(usuario);
				return Void.TYPE;
			})
			.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
	}*/
	
	/*
	@PutMapping("/novasenha/{username}")
	public Usuario update(@RequestBody @Valid Usuario usuario, String username) {
		String senhaCriptografada = passwordEncoder.encode(usuario.getU_password());
		usuario.setU_password(senhaCriptografada);
		return usuarioService.salvar(usuario);
	}*/
	
	
	@GetMapping("/info/usuario/{username}")
	public List<Usuario> listaInfoUsuario( @PathVariable String username ) {
		List<Usuario> usuario = new ArrayList<>();
		/*VERIFICAR SE ADMIN*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		if(decriptToken.getUsername().contains(username)) {
			usuario = usuarioService.listandoInfoUsuario(username);
		}
		return usuario;
	}
	
	@PostMapping("/auth")
	public TokenDTO autenticar(@RequestBody CredenciaisDTO credenciais) {
		try {
			Usuario usuario = Usuario.builder()
					.id_login(credenciais.getId_login())
					.username(credenciais.getUsername())
					.u_password(credenciais.getU_password()).build();
			
			//System.out.println("Usuario"+usuario.getUsername());
			
			UserDetails usuarioAutenticado = usuarioService.autenticar(usuario);
			
			String token = jwtService.gerarToken( usuario );	
			
			return new TokenDTO(usuario.getId_login(), usuario.getUsername(), token);

		}catch ( UsernameNotFoundException | SenhaInvalidaException e ) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}
	}

}
