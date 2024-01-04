package br.com.witzler.clientes.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.dto.ComercializadoraDTO;
import br.com.witzler.clientes.domain.entity.Comercializadora;
import br.com.witzler.clientes.domain.repositorio.ComercializadoraRepositorio;

@RestController
@RequestMapping("/api/")
public class ComercializadoraController {
	
	@Autowired
	private ComercializadoraRepositorio comercializadoraRepositorio;
	
	@GetMapping("comercializadora")
	ArrayList<ComercializadoraDTO> listaInfo( @RequestParam("id_comercializadora") Integer id_comercializadora) {
		
		List<Comercializadora> comercializadora = comercializadoraRepositorio.listandoInfoComercializadora(id_comercializadora);
		
		ArrayList<ComercializadoraDTO> ConjuntoComercializadora = new ArrayList<>();
		
		for (int i=0; i<comercializadora.size(); i++)
		{
			ComercializadoraDTO com = new ComercializadoraDTO();
			com.setId_comercializadora(comercializadora.get(i).getId_comercializadora());
			com.setNome(comercializadora.get(i).getNome());
			com.setPath(comercializadora.get(i).getPath());
			com.setCow_id(comercializadora.get(i).getCow_id());
			
			ConjuntoComercializadora.add(com);
		}
		
		return ConjuntoComercializadora;
		
	}

}
