package br.com.witzler.clientes.domain.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.witzler.clientes.domain.entity.WebRecuperacao;

public interface WebRecuperacaoRepositorio extends JpaRepository<WebRecuperacao, Integer> {

	@Query(value="DELETE FROM pc.web_recuperacao WHERE utilizador = :utilizador AND confirmacao = :confirmacao", nativeQuery=true)
	void deletaRecuperacao( @Param("utilizador") String utilizador,
							@Param("confirmacao") String confirmacao);
}
