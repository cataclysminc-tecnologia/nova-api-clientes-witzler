package br.com.witzler.clientes.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.witzler.clientes.domain.entity.Cliente;
import br.com.witzler.clientes.domain.repositorio.Clientes;
import br.com.witzler.clientes.security.jwt.JwtSecurityValidateToken;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	private Clientes clientes;
	
	public ClienteController(Clientes clientes) {
		super();
		this.clientes = clientes;
	}

	//Showing data of a client from his id
	// COMENTADO POR joao.jacomo 13/11/2023 
//	@GetMapping("/{id_login}")
//	public Cliente getClienteByIdLogin( @PathVariable Integer id_login ) {
//		// System.out.println(id_login);
//		/*VERIFICAR SE ADMIN*/
//		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken();
//		if(decriptToken.isAdmin()) {
//			return clientes
//					.findById(id_login)
//					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "*** ERROR: Cliente não encontrado! ***"));
//		}else {
//			return null;
//		}
//		/*FIM VERIFICAR SE ADMIN*/
//	}
	
	
	//Method to register a client
	// COMENTADO POR joao.jacomo 13/11/2023
//	@PostMapping("/register")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Cliente save( @RequestBody @Valid Cliente cliente ) {
//		/*VERIFICAR SE ADMIN*/
//		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken();
//		if(decriptToken.isAdmin()) {
//			return clientes.save(cliente);
//		}else {
//			return null;
//		}
//		/*FIM VERIFICAR SE ADMIN*/
//	}
	
	
	
	//Method to delete a client
	// COMENTADO POR joao.jacomo 13/11/2023
//	@DeleteMapping("/delete/{id_login}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete( @PathVariable Integer id_login ){
//		/*VERIFICAR SE ADMIN*/
//		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken();
//		if(decriptToken.isAdmin()) {
//			clientes.findById(id_login)
//            .map( cliente -> {
//                clientes.delete(cliente );
//                return cliente;
//            })
//            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
//                    "Cliente não encontrado") );
//		}
//		/*FIM VERIFICAR SE ADMIN*/
//
//    }
	
	
	//Method to update a client
	// COMENTADO POR joao.jacomo 13/11/2023
//	@PutMapping("/update/{id_login}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void update( @PathVariable Integer id_login, @RequestBody Cliente cliente ) {
//		/*VERIFICAR SE ADMIN*/
//		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken();
//		if(decriptToken.isAdmin()) {
//			clientes
//			.findById(id_login)
//			.map( clienteExistente -> {
//				cliente.setId_login(clienteExistente.getId_login());
//				clientes.save(cliente);
//				return clienteExistente;
//			}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
//					"Cliente não encontrado") );
//		}
//		/*FIM VERIFICAR SE ADMIN*/
//	}
	
	
	
	//Method to search a client
	// COMENTADO POR joao.jacomo 13/11/2023
//	@GetMapping("/search")
//	public List<Cliente> find( Cliente filtro ) {		
//		/*VERIFICAR SE ADMIN*/
//		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken();
//		if(decriptToken.isAdmin()) {
//			ExampleMatcher matcher = ExampleMatcher
//					.matching()
//					.withIgnoreCase()
//					.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
//
//			Example example = Example.of(filtro, matcher);
//			return clientes.findAll(example);
//		}
//		/*FIM VERIFICAR SE ADMIN*/
//		return new ArrayList<Cliente>();
//	}
	
	/*@COMENTADO POR: joao.jacomo 09/11/2023: ESSE REQUEST NÃO ESTÁ FUNCIONANDO MAS ESTÁ SENDO UTILIZADO NO PHP, ENTÃO, DEIXEI SEM COMENTAR*/
	@GetMapping("/id/cliente/{username}")
	public List<Cliente> listandoCliente( @PathVariable(value="username") String username ) {		
		return clientes.findByUsernameLike(username);
	}
	
	
}
