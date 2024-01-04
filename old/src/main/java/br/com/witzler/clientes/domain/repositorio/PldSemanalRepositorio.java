package br.com.witzler.clientes.domain.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.witzler.clientes.domain.entity.PldSemanal;

public interface PldSemanalRepositorio extends JpaRepository<PldSemanal, Integer> {
	
	//@Query(value = "SELECT * FROM pc.web_pld_semanal where id = :id ORDER BY id DESC LIMIT 1")
	//List<PldSemanal> listandoPld(Integer id);

}
