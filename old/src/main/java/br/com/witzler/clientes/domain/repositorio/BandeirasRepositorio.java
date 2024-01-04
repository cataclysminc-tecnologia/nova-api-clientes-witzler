package br.com.witzler.clientes.domain.repositorio;

import br.com.witzler.clientes.domain.entity.Bandeiras;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BandeirasRepositorio extends JpaRepository<Bandeiras, Integer> {
	
	@Query(value="SELECT id_bandeira, data_inicio, tipo_bandeira FROM pc.web_bandeiras WHERE EXTRACT(MONTH FROM data_inicio)= :mes AND EXTRACT(YEAR FROM data_inicio) = :ano", nativeQuery=true)
	//List<Bandeiras> encontrarPorMesEAno( @Param("mes") Integer mes, @Param("ano") Integer ano );
	Bandeiras encontrarPorMesEAno(Integer mes, Integer ano);
	
	
	
}
