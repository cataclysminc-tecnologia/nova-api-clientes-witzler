package br.com.witzler.clientes.api.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.entity.WebLoginAcesso;
import br.com.witzler.clientes.domain.repositorio.WebLoginAcessoRepositorio;

@RestController
@RequestMapping("/api/loginacesso")
public class WebLoginAcessoController {
	
	private WebLoginAcessoRepositorio wla;
	
	public WebLoginAcessoController( WebLoginAcessoRepositorio wla )
	{
		super();
		this.wla = wla;
	}
	
	// Método para registrar novo login
	@PostMapping("/registraacesso")
	@ResponseStatus(HttpStatus.CREATED)
	public WebLoginAcesso save( @RequestBody @Valid WebLoginAcesso login )
	{
		return wla.save(login);
	}

}
