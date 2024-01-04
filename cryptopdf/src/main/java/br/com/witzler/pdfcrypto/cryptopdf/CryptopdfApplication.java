package br.com.witzler.pdfcrypto.cryptopdf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.witzler.pdfcrypto.cryptopdf.encryptor.Crypto;

@SpringBootApplication
public class CryptopdfApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CryptopdfApplication.class, args);
		Crypto.main();
	}

}
