package br.com.witzler.clientes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {
	
	private Integer id_login;
	private String username;
	private String token;

}
