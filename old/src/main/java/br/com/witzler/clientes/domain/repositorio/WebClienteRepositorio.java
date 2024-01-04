package br.com.witzler.clientes.domain.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.witzler.clientes.domain.entity.Usuario;
import br.com.witzler.clientes.domain.entity.UsuariosColaboradores;
import br.com.witzler.clientes.domain.entity.WebCliente;

public interface WebClienteRepositorio extends JpaRepository<WebCliente, Integer>{

	// Esta query devolve todos os clientes que um usuario colaborador específico tem
	@Query(value="select * from pc.web_cliente WHERE colaborador_tec_id = :colaborador_tec_id", nativeQuery=true)
	List<WebCliente> listandoTudoClientes( int colaborador_tec_id );
	
	// Esta query devolve todos os clientes quando o colaborador é admin
	@Query(value="select * from pc.web_cliente", nativeQuery=true)
	List<WebCliente> listandoTodosClientes();
	
	// Esta query devolve todos os clientes quando o colaborador é admin
	@Query(value="select count(*) from pc.web_cliente", nativeQuery=true)
	List<WebCliente> listandoQtdeClientes();
	
	// Esta query lista todas as informações de conta de usuário cliente através do id_cliente
	@Query(value="select * from pc.web_cliente where id_cliente = :id_cliente", nativeQuery=true)
	List<WebCliente> listandoTudoPorId( int id_cliente );
	
}
