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


import br.com.witzler.clientes.domain.entity.Usuario;
import br.com.witzler.clientes.domain.repositorio.UsuarioRepository;
import br.com.witzler.clientes.exception.SenhaInvalidaException;


@Service
public class UsuarioServiceImpl implements UserDetailsService {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UsuarioRepository repository;
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		//System.out.println("jodido"+usuario.getId_login());
		return repository.save(usuario);
	}
	
	
	public List<Usuario> listandoInfoUsuario(String username) {
		return repository.listandoTudo(username);
	}
	
	
	
	/*
	public void update( Integer id_login, Usuario usuario) {
		
	}*/
	
	
	
	
	public UserDetails autenticar( Usuario usuario ) {
		UserDetails user = loadUserByUsername(usuario.getUsername());
		boolean senhasBatem = encoder.matches(usuario.getU_password(), user.getPassword() );
		
		if(senhasBatem) {
			return user;
		}
		throw new SenhaInvalidaException();
		
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repository.findByUsername(username)
					.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado no banco de dados"));
		
		String[] roles = usuario.isAdmin() ? new String[] {"ADMIN", "USER"} : new String[] {"USER"};
		Integer idUser = usuario.getId_login();
		//System.out.println("Valor: " + idUser);
		return User
				.builder()
				//id_login(idUser)
				.username(usuario.getUsername() + " " + "valor: " + idUser)
				.password(usuario.getU_password())
				.roles(roles)
				.build();
		
	}

}
