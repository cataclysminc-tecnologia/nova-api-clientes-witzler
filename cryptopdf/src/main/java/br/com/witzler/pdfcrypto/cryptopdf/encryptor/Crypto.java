package br.com.witzler.pdfcrypto.cryptopdf.encryptor;

public class Crypto {
	public static void main() throws Exception {
		//String caminhoEncrypt = new File("src/main/resources/originais").getAbsolutePath().toString();
		//EncryptorAesGcmPasswordFile.encryptAll("cdb848f349e571b0231a3dd358c528bc380321e28963ece56f6f59b0a1de2188");
		
		//String caminhoDecrypt = new File("src/main/resources/encriptados").getAbsolutePath().toString();
		//EncryptorAesGcmPasswordFile.decryptAll("cdb848f349e571b0231a3dd358c528bc380321e28963ece56f6f59b0a1de2188");
		
		//EncryptorAesGcmPasswordFile.descriptarOne("pdfteste4.encrypted.txt", "password123");
		
		//EncryptorAesGcmPasswordFile.decryptOne("pdfteste.pdf", "cdb848f349e571b0231a3dd358c528bc380321e28963ece56f6f59b0a1de2188");
		
		//new Thread();
		//Thread.sleep(3000 * 60);  
		//EncryptorAesGcmPasswordFile.deletarPdf();
		//EncryptorAesGcmPasswordFile.deleteOne("pdfteste2.pdf", "cdb848f349e571b0231a3dd358c528bc380321e28963ece56f6f59b0a1de2188");
		
		EncryptorAesGcmPasswordFile.testeExisteArquivo();
		System.out.println("Fim codigo");
	}
}
