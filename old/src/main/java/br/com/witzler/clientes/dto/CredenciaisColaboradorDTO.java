package br.com.witzler.clientes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CredenciaisColaboradorDTO {
	
	private Integer id_colaborador;
	private String username;
	private String password_colaborador;
}
