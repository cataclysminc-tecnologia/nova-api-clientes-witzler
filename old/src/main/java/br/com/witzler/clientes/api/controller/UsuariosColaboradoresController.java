package br.com.witzler.clientes.api.controller;

import java.util.List;

import javax.validation.Valid;

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
import br.com.witzler.clientes.domain.entity.UsuariosColaboradores;
import br.com.witzler.clientes.domain.repositorio.Clientes;
import br.com.witzler.clientes.domain.repositorio.UsuarioRepository;
import br.com.witzler.clientes.domain.repositorio.UsuariosColaboradoresRepository;
import br.com.witzler.clientes.dto.CredenciaisColaboradorDTO;
import br.com.witzler.clientes.dto.CredenciaisDTO;
import br.com.witzler.clientes.dto.TokenDTO;
import br.com.witzler.clientes.exception.SenhaInvalidaException;
import br.com.witzler.clientes.security.jwt.JwtService;
import br.com.witzler.clientes.service.impl.UsuarioServiceImpl;
import br.com.witzler.clientes.service.impl.UsuariosColaboradoresServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarioscolaboradores")
@RequiredArgsConstructor
public class UsuariosColaboradoresController {
//	private final PasswordEncoder passwordEncoder;
//	private final JwtService jwtService;
//	private final UsuariosColaboradoresServiceImpl usuarioService;
//	private final UsuariosColaboradoresRepository repository;

//	@PostMapping("criarUsuarioColaborador")
//	@ResponseStatus(HttpStatus.CREATED)
//	public UsuariosColaboradores salvar(@RequestBody @Valid UsuariosColaboradores usuario) {
//		String senhaCriptografada = passwordEncoder.encode(usuario.getPassword_colaborador());
//		usuario.setPassword_colaborador(senhaCriptografada);
//		return usuarioService.salvar(usuario);
//	}

//	@PutMapping("/updatecolaborador/{id_colaborador")
//	public UsuariosColaboradores update(@RequestBody @Valid UsuariosColaboradores usuario, Integer id_colaborador) {
//		String senhaCriptografada = passwordEncoder.encode(usuario.getPassword_colaborador());
//		usuario.setPassword_colaborador(senhaCriptografada);
//		return usuarioService.salvar(usuario);
//	}
//
//	@DeleteMapping("/elimina-colaborador/{username}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void deletar(@PathVariable String username) {
//		repository.findByUsername(username).map(usuario -> {
//			repository.delete(usuario);
//			return Void.TYPE;
//		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//	}
//	
//	@PutMapping("/novasenha-colaborador/{username}")
//	public UsuariosColaboradores update(@RequestBody @Valid UsuariosColaboradores usuario, String username) {
//		String senhaCriptografada = passwordEncoder.encode(usuario.getPassword_colaborador());
//		usuario.setPassword_colaborador(senhaCriptografada);
//		return usuarioService.salvar(usuario);
//	}
//	
//	@GetMapping("/info/usuario-colaborador/{username}")
//	public List<UsuariosColaboradores> listaInfoUsuario(@PathVariable String username) {
//		List<UsuariosColaboradores> usuario = usuarioService.listandoInfoUsuarioColaborador(username);
//		return usuario;
//	}
//	
//	@GetMapping("/info/clientes-colaborador/{colaborador_tec_id}")
//	public List<UsuariosColaboradores> listaClientesUsuario(@PathVariable int colaborador_tec_id) {
//		List<UsuariosColaboradores> usuario = usuarioService.listandoClientesUsuarioColaborador(colaborador_tec_id);
//		return usuario;
//	}
//
//	@PostMapping("/auth-colaborador")
//	public TokenDTO autenticar(@RequestBody CredenciaisColaboradorDTO credenciais) {
//		try {
//			UsuariosColaboradores usuario = UsuariosColaboradores.builder()
//					.id_colaborador(credenciais.getId_colaborador()).username(credenciais.getUsername())
//					.password_colaborador(credenciais.getPassword_colaborador()).build();
//
//			UserDetails usuarioAutenticado = usuarioService.autenticarColaborador(usuario);
//			String token = jwtService.gerarTokenColaborador(usuario);
//			return new TokenDTO(usuario.getId_colaborador(), usuario.getUsername(), token);
//
//		} catch (UsernameNotFoundException | SenhaInvalidaException e) {
//			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
//		}
//	}
}
