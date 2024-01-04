package br.com.witzler.clientes.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.dto.EspelhoAclDTO;
import br.com.witzler.clientes.domain.entity.EspelhoAcl;
import br.com.witzler.clientes.domain.repositorio.EspelhoAclRepositorio;

@RestController
@RequestMapping("/api/")
public class EspelhoAclController {
	
	@Autowired
	private EspelhoAclRepositorio espelhoAclRepositorio;

	@GetMapping("relatorios/espelho")
	List<EspelhoAcl> listaRelatoriosEspelho( @RequestParam("distribuidora_id") Integer distribuidora_id,
											 @RequestParam("tarifa") Integer tarifa) {
		
		//System.out.println("distribuidora_id: " + distribuidora_id);
		//System.out.println("tarifa: " + tarifa);
		
		List<EspelhoAcl> espelhoAcl = espelhoAclRepositorio.listandoRelatoriosEspelho(distribuidora_id, tarifa);
		System.out.println("resultados: " + espelhoAcl);
		
		ArrayList<EspelhoAclDTO> ConjuntoEspelhoAcl = new ArrayList<>();
		
		return espelhoAcl;
		
	}
	
}
