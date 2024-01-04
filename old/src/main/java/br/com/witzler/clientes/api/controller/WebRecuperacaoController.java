package br.com.witzler.clientes.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.repositorio.WebRecuperacaoRepositorio;

@RestController
@RequestMapping("/api/")
public class WebRecuperacaoController {
	
	@Autowired
	WebRecuperacaoRepositorio repositorio;
	
	@DeleteMapping("webrecuperacao/delete")
	public void deletar( @RequestParam("utilizador") String utilizador,
						 @RequestParam("confirmacao") String confirmacao) {
		
		repositorio.deletaRecuperacao(utilizador, confirmacao);
			
	}

}
