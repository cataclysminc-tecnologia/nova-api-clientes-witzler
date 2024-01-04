package br.com.witzler.clientes.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.witzler.clientes.decryptpdf.EncryptorAesGcmPasswordFile;
import br.com.witzler.clientes.domain.entity.WebCliente;
import br.com.witzler.clientes.domain.repositorio.WebClienteRepositorio;
import br.com.witzler.clientes.security.jwt.JwtSecurityValidateToken;

@RestController
@RequestMapping("/api/")
public class DecriptarPdfController {

	@Autowired
	private WebClienteRepositorio webClienteRepositorio;
	
	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;
	
	private EncryptorAesGcmPasswordFile decryptPdf;

	// Método que decripta um arquivo selecionado
	@GetMapping("decripta-pdf")
	String descriptarPdf(@RequestParam("arquivo") String arquivo) throws Exception {
		String arquivoDecriptado = "[]";
		/*VALIDAÇÃO TOKEN PELO CLIENT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		/*FIM VALIDAÇÃO TOKEN PELO CLIENT ID*/
		if(decriptToken.urlIsFromClient(webClienteRepositorio, decriptToken.getId_client(), arquivo)) {
			 arquivoDecriptado = decryptPdf.decryptOne(arquivo,
					"cdb848f349e571b0231a3dd358c528bc380321e28963ece56f6f59b0a1de2188");
		}
		
		return arquivoDecriptado;
	}
	
	// Método que deleta um arquivo depois de 3 minutos:
	/*@GetMapping("deletar-pdf")
	String deletarPdf(@RequestParam("arquivo") String arquivo) throws InterruptedException {
		//new Thread();
		//Thread.sleep(2000 * 600);
		String arquivoDeletado = decryptPdf.deleteOne(arquivo,
				"cdb848f349e571b0231a3dd358c528bc380321e28963ece56f6f59b0a1de2188");
		return arquivoDeletado;
	}*/

	/*
	 * @GetMapping("obter-pdf") String obeterPdf(@RequestParam("arquivo") String
	 * arquivo) throws Exception { String arquivoDecriptado =
	 * decryptPdf.decryptOne(arquivo,
	 * "cdb848f349e571b0231a3dd358c528bc380321e28963ece56f6f59b0a1de2188"); return
	 * ""; }
	 */
}
