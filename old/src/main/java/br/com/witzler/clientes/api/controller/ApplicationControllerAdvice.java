package br.com.witzler.clientes.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.witzler.clientes.exception.RegraNegocioException;
import br.com.witzler.clientes.rest.ApiErrors;

@ControllerAdvice
public class ApplicationControllerAdvice {
	
	@ExceptionHandler(RegraNegocioException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors handleRegraNegocioException(RegraNegocioException ex) {
		String mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors handleMethodNotValidException(MethodArgumentNotValidException ex) {
		List<String> errors = ex.getBindingResult().getAllErrors()
					.stream()
					.map( erro -> erro.getDefaultMessage() )
					.collect(Collectors.toList());
		
		return new ApiErrors(errors);
	}

}
