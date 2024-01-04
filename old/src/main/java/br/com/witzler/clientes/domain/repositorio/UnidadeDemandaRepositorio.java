package br.com.witzler.clientes.domain.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.witzler.clientes.domain.entity.UnidadeDemanda;

public interface UnidadeDemandaRepositorio extends JpaRepository<UnidadeDemanda, Integer> {

	@Query(value = "select * from pc.web_unidade_demanda where unidade_id = :unidade_id order by mes_ref desc limit 2", nativeQuery=true)
	List<UnidadeDemanda> listandoDemanda( Integer unidade_id );
	
}
