package br.com.witzler.clientes.domain.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ArquivosRelatoriosDTO {
	
	private Date 	data_referencia;
	private Integer tipo_arquivo;
	private String 	caminho;
	private String 	tipo_arquivo_descricao;

}
