package br.com.witzler.clientes.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.entity.Bandeiras;
import br.com.witzler.clientes.domain.repositorio.BandeirasRepositorio;

@RestController
@RequestMapping("/api/bandeiras")
public class BandeirasController {
	
	
	@Autowired
	BandeirasRepositorio bandeirasRepositorio;
	
	private BandeirasRepositorio bandeiras;
	
	public BandeirasController(BandeirasRepositorio bandeiras) {
		this.bandeiras = bandeiras;
	}
	
	//Method to visualize all flags
	@GetMapping("/")
	public List <Bandeiras> listaBandeiras() {
		return bandeirasRepositorio.findAll();
	}
	
	
	@GetMapping("/{mes}/{ano}")
	public Bandeiras getBandeirasByMesEAno ( @PathVariable Integer mes, @PathVariable Integer ano) {
		Bandeiras bandeiras = bandeirasRepositorio.encontrarPorMesEAno(mes, ano);
		return bandeiras;		
	}
	
}
