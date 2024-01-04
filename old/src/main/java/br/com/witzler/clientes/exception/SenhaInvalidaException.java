package br.com.witzler.clientes.exception;

public class SenhaInvalidaException extends RuntimeException {
	
	public SenhaInvalidaException() {
		super("Senha inválida!");
	}

}
