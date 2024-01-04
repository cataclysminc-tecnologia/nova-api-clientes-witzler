package br.com.witzler.clientes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.witzler.clientes.security.jwt.JwtAuthFilter;
import br.com.witzler.clientes.security.jwt.JwtService;
import br.com.witzler.clientes.service.impl.UsuarioServiceImpl;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@Autowired
	private JwtService jwtService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public OncePerRequestFilter jwtFilter() {
		return new JwtAuthFilter(jwtService, usuarioService);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			//.csrf().disable()
			.userDetailsService(usuarioService)
			.passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
			.authorizeRequests()
				.antMatchers("/api/bandeiras/**").authenticated()
				.antMatchers("/api/atualiza/alerta/reativos/").authenticated()
				.antMatchers("/api/consulta/alerta/**").authenticated()
				.antMatchers("/api/arquivos/**").authenticated()
				.antMatchers("/api/datas/**").authenticated()
				.antMatchers("/api/tipos/**").authenticated()
				//.antMatchers("/api/arquivos/unidade/").authenticated()
				//.antMatchers("/api/datas/arquivos/unidade/").authenticated()
				//.antMatchers("/api/tipos/arquivos/unidade/").authenticated()
				.antMatchers("/api/clientes/**").authenticated()
				.antMatchers("/api/informacaoCliente/**").authenticated()
				.antMatchers("/api/atendenteComercial/**").authenticated()
				.antMatchers("/api/atendenteTecnico/**").authenticated()
				.antMatchers("/api/distribuidora/**").authenticated()
				//.antMatchers("/api/relatorios/**").authenticated()
				.antMatchers("/api/atendenteComercial/**").authenticated()
				.antMatchers("/api/periodo/**").authenticated()
				.antMatchers("/api/media/**").authenticated()
				.antMatchers("/api/medidas/**").authenticated()
				//.antMatchers("/api/periodo/ativoc/").authenticated()
				.antMatchers("/api/economia/**").authenticated()
				.antMatchers("/api/listando/**").authenticated()
				.antMatchers("/api/pld/**/").authenticated()
				//.antMatchers("/api/relatorios/valores/").authenticated()
				.antMatchers("/api/unidade/**").authenticated()
				.antMatchers("/api/unidades/**").authenticated()
				.antMatchers("/api/unidadesNome/**").authenticated()
				.antMatchers("/api/atendenteComercial/**").authenticated()
				//.antMatchers("/api/usuarios/info/usuario/**").authenticated()
				.antMatchers("/api/usuarios/criarUsuario/**").authenticated()
				.antMatchers("/api/usuarios/elimina/**").authenticated()
				.antMatchers("/api/usuarios/update/**").authenticated()
				.antMatchers("/api/relatorioResumo/**").authenticated()
				.antMatchers("/api/usuarios/auth/").permitAll()
				//.anyRequest().denyAll()
				
		.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
			.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
		
								
		;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(
				"/v2/api-docs",
				"/configuration/ui",
				"/sqagger-resources/**",
				"/configuration/security",
				"/swagger-resources/**",
				"/swagger-ui.html",
				"/webjars/**");
	}
	
}
