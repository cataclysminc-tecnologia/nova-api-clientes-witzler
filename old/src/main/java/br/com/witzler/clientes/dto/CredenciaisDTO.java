package br.com.witzler.clientes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class CredenciaisDTO {
	
	private Integer id_login;
	private String username;
	private String u_password;

}
