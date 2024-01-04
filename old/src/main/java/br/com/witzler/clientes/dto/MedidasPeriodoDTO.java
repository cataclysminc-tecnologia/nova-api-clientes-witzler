package br.com.witzler.clientes.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedidasPeriodoDTO {
	private Integer unidade_id;
	private String data_inicial;
	private String data_final;
}
