package br.com.witzler.clientes.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.dto.DistribuidoraDTO;
import br.com.witzler.clientes.domain.entity.Distribuidora;
import br.com.witzler.clientes.domain.repositorio.DistribuidoraRepositorio;

@RestController
@RequestMapping("/api/")
public class DistribuidoraController {
	
	@Autowired
	private DistribuidoraRepositorio repository;
	
	@GetMapping("distribuidora")
	ArrayList<DistribuidoraDTO> listaDistribuidora( @RequestParam("id_distribuidora") Integer id_distribuidora ) {
		
		List<Distribuidora> distribuidora = repository.listarDistribuidora(id_distribuidora);
		//System.out.println(distribuidora);
		
		ArrayList<DistribuidoraDTO> ConjuntoDistribuidora = new ArrayList<>();
		
		for ( int i=0; i<distribuidora.size(); i++ )
		{
			DistribuidoraDTO d = new DistribuidoraDTO();
			d.setId_distribuidora(distribuidora.get(i).getId_distribuidora());
			d.setNome_distribuidora(distribuidora.get(i).getNome_distribuidora());
			d.setDescricao_distribuidora(distribuidora.get(i).getDescricao_distribuidora());
			
			ConjuntoDistribuidora.add(d);
		}
		
		return ConjuntoDistribuidora;
		
	}
	

}
