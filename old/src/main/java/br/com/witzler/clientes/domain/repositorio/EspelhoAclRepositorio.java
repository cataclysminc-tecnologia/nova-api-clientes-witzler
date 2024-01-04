package br.com.witzler.clientes.domain.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.witzler.clientes.domain.entity.EspelhoAcl;

public interface EspelhoAclRepositorio extends JpaRepository<EspelhoAcl, Integer> {
	
	@Query(value="SELECT * FROM pc.web_espelho_acl WHERE distribuidora_id = :distribuidora_id AND tarifa = :tarifa", nativeQuery=true)
	List<EspelhoAcl> listandoRelatoriosEspelho(Integer distribuidora_id, Integer tarifa);

}
