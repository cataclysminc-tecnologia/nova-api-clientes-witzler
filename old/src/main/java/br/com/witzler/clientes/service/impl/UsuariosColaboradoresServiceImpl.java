package br.com.witzler.clientes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import br.com.witzler.clientes.domain.entity.UsuariosColaboradores;
import br.com.witzler.clientes.domain.repositorio.UsuariosColaboradoresRepository;
import br.com.witzler.clientes.exception.SenhaInvalidaException;

@Service
public class UsuariosColaboradoresServiceImpl {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UsuariosColaboradoresRepository repository;
	
	@Transactional
	public UsuariosColaboradores salvar(UsuariosColaboradores usuario) {
		return repository.save(usuario);
	}
	
	public List<UsuariosColaboradores> listandoInfoUsuarioColaborador(String username) {
		return repository.listandoTudo(username);
	}
	
	public List<UsuariosColaboradores> listandoClientesUsuarioColaborador(int colaborador_tec_id) {
		return repository.listandoTudoClientes(colaborador_tec_id);
	}
	
	public UserDetails autenticarColaborador(UsuariosColaboradores usuario) {
		UserDetails user = loadUserByUsername(usuario.getUsername());
		boolean senhasBatem = encoder.matches(usuario.getPassword_colaborador(), user.getPassword() );
		
		if(senhasBatem) {
			return user;
		}
		throw new SenhaInvalidaException();
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuariosColaboradores usuario = repository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado no banco de dados"));;
		String[] roles = usuario.isAdministrador() ? new String[] {"ADMIN", "USER"} : new String[] {"USER"};
		Integer idUser = usuario.getId_colaborador();
		
		return User
				.builder()
				//id_login(idUser)
				.username(usuario.getUsername() + " " + "valor: " + idUser)
				.password(usuario.getPassword_colaborador())
				.roles(roles)
				.build();
	}
}
