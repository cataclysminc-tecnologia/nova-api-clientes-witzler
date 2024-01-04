package br.com.witzler.clientes.domain.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.witzler.clientes.domain.entity.Colaborador;

public interface ColaboradorRepositorio extends JpaRepository<Colaborador, Integer> {
	
	//Query para listar dados de atendente comercial
	@Query(value="SELECT Colab.id_colaborador, Colab.nome_colaborador, Colab.email, Colab.telefone_1, Colab.telefone_2, Colab.path_img FROM pc.web_colaborador Colab INNER JOIN (SELECT id_cliente, nome, email, nome_fantasia, colaborador_tec_id, colaborador_comercial_id, cow_client_id FROM pc.web_cliente WHERE id_cliente = (SELECT client_id FROM pc.web_login_cliente INNER JOIN (SELECT id_login FROM pc.web_login WHERE  username = :username) AS TABELA ON TABELA.id_login = login_id))AS CLI ON CLI.colaborador_comercial_id = Colab.id_colaborador", nativeQuery=true)
	List<Colaborador> listarAtendenteComercial(@Param("username") String username);
	
	//Query para listar dados atendente técnico
	@Query(value="SELECT Colab.id_colaborador, Colab.nome_colaborador, Colab.email, Colab.telefone_1, Colab.telefone_2, Colab.path_img FROM pc.web_colaborador Colab INNER JOIN (SELECT id_cliente, nome, email, nome_fantasia, colaborador_tec_id, colaborador_comercial_id, cow_client_id FROM pc.web_cliente WHERE id_cliente = (SELECT client_id FROM pc.web_login_cliente INNER JOIN (SELECT id_login FROM pc.web_login WHERE  username = :username) AS TABELA ON TABELA.id_login = login_id))AS CLI ON CLI.colaborador_tec_id = Colab.id_colaborador", nativeQuery=true)
	List<Colaborador> listarAtendenteTecnico(@Param("username") String username);

}
