package br.com.witzler.clientes.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.entity.PldSemanal;
import br.com.witzler.clientes.domain.repositorio.PldSemanalRepositorio;

@RestController
@RequestMapping("/api/")
public class PldSemanalController {
	
	@Autowired
	PldSemanalRepositorio repository;
	
	@GetMapping("pld/semanal")
	public List<PldSemanal> listaPld() {
		return repository.findAll();
	}

}
