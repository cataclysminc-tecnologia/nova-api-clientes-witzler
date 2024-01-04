package br.com.witzler.pdfcrypto.cryptopdf.encryptor;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

import br.com.witzler.pdfcrypto.cryptopdf.util.CryptoUtils;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EncryptorAesGcmPasswordFile {
	private static final String ENCRYPT_ALGO = "AES/GCM/NoPadding";
	private static final int TAG_LENGTH_BIT = 128; // must be one of {128, 120, 112, 104, 96}
	private static final int IV_LENGTH_BYTE = 12;
	private static final int SALT_LENGTH_BYTE = 16;

	private static final Charset UTF_8 = StandardCharsets.UTF_8;

	public static byte[] encrypt(byte[] pText, String password) throws Exception {

		// 16 bytes salt
		byte[] salt = CryptoUtils.getRandomNonce(SALT_LENGTH_BYTE);

		// GCM recommended 12 bytes iv?
		byte[] iv = CryptoUtils.getRandomNonce(IV_LENGTH_BYTE);

		// secret key from password
		SecretKey aesKeyFromPassword = CryptoUtils.getAESKeyFromPassword(password.toCharArray(), salt);

		Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);

		// ASE-GCM needs GCMParameterSpec
		cipher.init(Cipher.ENCRYPT_MODE, aesKeyFromPassword, new GCMParameterSpec(TAG_LENGTH_BIT, iv));

		byte[] cipherText = cipher.doFinal(pText);

		// prefix IV and Salt to cipher text
		byte[] cipherTextWithIvSalt = ByteBuffer.allocate(iv.length + salt.length + cipherText.length).put(iv).put(salt)
				.put(cipherText).array();

		return cipherTextWithIvSalt;

	}

	// we need the same password, salt and iv to decrypt it
	private static byte[] decrypt(byte[] cText, String password) throws Exception {

		// get back the iv and salt that was prefixed in the cipher text
		ByteBuffer bb = ByteBuffer.wrap(cText);

		byte[] iv = new byte[12];
		bb.get(iv);

		byte[] salt = new byte[16];
		bb.get(salt);

		byte[] cipherText = new byte[bb.remaining()];
		bb.get(cipherText);

		// get back the aes key from the same password and salt
		SecretKey aesKeyFromPassword = CryptoUtils.getAESKeyFromPassword(password.toCharArray(), salt);

		Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);

		cipher.init(Cipher.DECRYPT_MODE, aesKeyFromPassword, new GCMParameterSpec(TAG_LENGTH_BIT, iv));

		byte[] plainText = cipher.doFinal(cipherText);

		return plainText;

	}

	public static void encryptFile(String fromFile, String toFile, String password) throws Exception {
		// read a normal txt file
		// byte[] fileContent =
		// Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(fromFile).toURI()));
		byte[] fileContent = Files.readAllBytes(Paths.get(fromFile));
		// encrypt with a password
		byte[] encryptedText = EncryptorAesGcmPasswordFile.encrypt(fileContent, password);

		// save a file
		Path path = Paths.get(toFile);

		Files.write(path, encryptedText);

	}

	public static byte[] decryptFile(String fromEncryptedFile, String password) throws Exception {

		// read a file
		byte[] fileContent = Files.readAllBytes(Paths.get(fromEncryptedFile));

		return EncryptorAesGcmPasswordFile.decrypt(fileContent, password);

	}

	public static void testeExisteArquivo() {
		File file = new File("/opt/lampp/htdocs/web-clientes/backend/assets/files/clientes/unidades/2874/ARQUIVOS/FATURA_DISTRIBUIDORA/21-06//");
		if (file.exists()) {
			System.out.println("É uma pasta existente");
			File[] files = file.listFiles();
			if (files.length > 0) {
				// existe alguma coisa dentro da pasta:
				for (int i = 0; i < files.length; i++) {
					System.out.println(files[i].toString());
				}

			}
		} else {
			System.out.println("Esta pasta não existe");
		}
	}

	public static void encryptAll(String password) throws Exception {
		// File dir = new File(diretorio);
		// Defining main root on SO path
		String rootPath = new File("src/main/resources/").getAbsolutePath().toString();
		String originais = new File(rootPath + "/originais/").getAbsolutePath().toString();
		String encriptados = new File(rootPath + "/encriptados/").getAbsolutePath().toString();

		// Define paths como files
		File originaisPath = new File(originais);
		// File encriptadosPath = new File(encriptados);

		if (originaisPath.exists()) {
			// Caso onde é um diretorio real, então faz contagem de quantos subdiretorios
			// tem:
			File[] files = originaisPath.listFiles();
			if (files.length > 0) {
				// existe alguma coisa dentro da pasta:
				for (int i = 0; i < files.length; i++) {
					// Verifica que seja do tipo pdf:
					if (files[i].getName().endsWith(".pdf")) {
						String nomePdf = files[i].toString();
						// String rota = files[i].toString().substring(0,
						// files[i].toString().length() - files[i].getName().length());
						String nomeEncriptado = encriptados + "/"
								+ files[i].getName().substring(0, files[i].getName().length() - 4) + ".pdf";
						// System.out.println("Salvar em: " + nomePdf);
						// System.out.println("Salvar como: " + nomeEncriptado);
						// System.out.println("");
						EncryptorAesGcmPasswordFile.encriptarPdf(nomePdf, nomeEncriptado, password);
					}
				}
			} else {
				System.out.println("Não foi encontrado nenhum arquivo em " + originais);
			}
		} else {
			System.out.println("Não existe a rota " + originais);
		}
	}

	public static void decryptAll(String password) throws Exception {
		// Defining main root on SO path
		String rootPath = new File("src/main/resources/").getAbsolutePath().toString();
		String decriptados = new File(rootPath + "/decriptados/").getAbsolutePath().toString();
		String encriptados = new File(rootPath + "/encriptados/").getAbsolutePath().toString();

		// Define paths como files
		// File decriptadosPath = new File(decriptados);
		File encriptadosPath = new File(encriptados);

		if (encriptadosPath.exists()) {
			// Caso onde existe a pasta encrptados, então verifica se tem arquivos:
			File[] files = encriptadosPath.listFiles();
			if (files.length > 0) {
				// Existe algum arquivo:
				for (int i = 0; i < files.length; i++) {
					// Verifica que seja do tipo .encrypted.txt:
					if (files[i].getName().endsWith(".pdf")) {
						String nomeEncriptado = files[i].toString();
						// String rota = files[i].toString().substring(0,
						// files[i].toString().length() - files[i].getName().length());
						String nomeDecriptado = decriptados + "/"
								+ files[i].getName().substring(0, files[i].getName().length() - 4) + ".pdf";
						// System.out.println(nomeEncriptado);
						// System.out.println(nomeDecriptado);
						EncryptorAesGcmPasswordFile.decryptPdf(nomeEncriptado, nomeDecriptado, password);
					}
				}
			} else {
				System.out.println("Não existem arquivos em " + encriptados);
			}
		} else {
			System.out.println("Não existe a rota " + encriptados);
		}
	}

	public static String decryptOne(String arquivo, String password) throws Exception {
		// Defining main root on SO path
		String rootPath = new File("src/main/resources/").getAbsolutePath().toString();
		String decriptados = new File(rootPath + "/decriptados/").getAbsolutePath().toString();
		String encriptados = new File(rootPath + "/encriptados/").getAbsolutePath().toString();

		// Define paths como files
		File encriptadosPath = new File(encriptados);

		if (encriptadosPath.exists()) {
			// Caso onde existe a pasta encrptados, então verifica se tem arquivos:
			File[] files = encriptadosPath.listFiles();
			if (files.length > 0) {
				// Existe algum arquivo:
				for (int i = 0; i < files.length; i++) {
					// Verifica que seja do tipo .encrypted.txt:
					if (files[i].getName().endsWith(arquivo)) {
						String nomeEncriptado = files[i].toString();
						String nomeDecriptado = decriptados + "/"
								+ files[i].getName().substring(0, files[i].getName().length() - 4) + ".pdf";
						EncryptorAesGcmPasswordFile.decryptPdf(nomeEncriptado, nomeDecriptado, password);
					}
				}
			} else {
				System.out.println("Não existem arquivos em " + encriptados);
			}
		} else {
			System.out.println("Não existe a rota " + encriptados);
		}

		return "";
	}

	public static void deletarPdf() {
		// Defining main root on SO path
		String rootPath = new File("src/main/resources/").getAbsolutePath().toString();
		String decriptados = new File(rootPath + "/decriptados/").getAbsolutePath().toString();
		// String encriptados = new File(rootPath +
		// "/encriptados/").getAbsolutePath().toString();

		// Define paths como files
		File decriptadosPath = new File(decriptados);
		// File encriptadosPath = new File(encriptados);

		if (decriptadosPath.exists()) {
			// Caso onde a pasta decriptados existe, então verifica se tem arquivos:
			File[] files = decriptadosPath.listFiles();
			if (files.length > 0) {
				// Existe algum arquivo:
				for (int i = 0; i < files.length; i++) {
					// Fazer limpeza geral da pasta, deleta tudo que tiver nela:
					System.out.println("from delete: " + files[i].toString());
					files[i].delete();
				}
			} else {
				System.out.println("Não tem arquivos para serem deletados");
			}
		} else {
			System.out.println("Não existe a rota para apagar " + decriptados);
		}
	}

	public static String deleteOne(String arquivo, String password) {
		// Defining main root on SO path
		String rootPath = new File("src/main/resources/").getAbsolutePath().toString();
		String decriptados = new File(rootPath + "/decriptados/").getAbsolutePath().toString();

		// Define paths como files
		File decriptadosPath = new File(decriptados);

		if (decriptadosPath.exists()) {
			// Caso onde a pasta decriptados existe, então verifica se tem arquivos:
			File[] files = decriptadosPath.listFiles();
			if (files.length > 0) {
				// Existe algum arquivo:
				for (int i = 0; i < files.length; i++) {
					if (files[i].getName().endsWith(arquivo)) {
						// Fazer limpeza geral da pasta, deleta tudo que tiver nela:
						System.out.println("from delete: " + files[i].toString());
						files[i].delete();
					}
				}
			} else {
				System.out.println("Não tem arquivos para serem deletados");
			}
		} else {
			System.out.println("Não existe a rota para apagar " + decriptados);
		}

		return "";
	}

	private static void encriptarPdf(String file, String salvarNome, String password) throws Exception {
		// EncryptorAesGcmPasswordFile encriptar = new EncryptorAesGcmPasswordFile(file,
		// salvarNome, "");
		EncryptorAesGcmPasswordFile.encryptFile(file, salvarNome, password);
		System.out.println("O arquivo " + file + " foi encriptado como " + salvarNome);
	}

	private static void decryptPdf(String file, String salvarNome, String password) throws Exception {
		byte[] decryptedText = EncryptorAesGcmPasswordFile.decryptFile(file, password);
		String pText = new String(decryptedText, UTF_8);
		// System.out.println(pText);
		System.out.println("O arquivo " + file + " foi descriptado como " + salvarNome);

		Path path = Paths.get(salvarNome);
		Files.write(path, decryptedText);
	}

	/*
	 * public static void descriptarOne(String caminho, String password) throws
	 * Exception { // Defining main root on SO path String rootPath = new
	 * File("src/main/resources/").getAbsolutePath().toString(); String originais =
	 * new File(rootPath + "/originais/").getAbsolutePath().toString(); String
	 * encriptados = new File(rootPath +
	 * "/encriptados/").getAbsolutePath().toString(); String decriptados = new
	 * File(rootPath + "/decriptados/").getAbsolutePath().toString();
	 * 
	 * // Define paths como files File originaisPath = new File(originais); File
	 * decriptadosPath = new File(decriptados); File encriptadosPath = new
	 * File(encriptados);
	 * 
	 * if (encriptadosPath.exists()) { // Caso onde existe a pasta encrptados, então
	 * verifica se tem arquivos: File[] files = encriptadosPath.listFiles(); if
	 * (files.length > 0) { for (int i = 0; i < files.length; i++) { // Verifica que
	 * o file seja igual a rota passada: if (files[i].getName().endsWith(caminho)) {
	 * String nomeEncriptado = files[i].toString(); String rota =
	 * files[i].toString().substring(0, files[i].toString().length() -
	 * files[i].getName().length()); String nomeDecriptado = decriptados + "/" +
	 * files[i].getName().substring(0, files[i].getName().length() - 14) + ".pdf";
	 * 
	 * EncryptorAesGcmPasswordFile.decryptPdf(nomeEncriptado, nomeDecriptado,
	 * password); System.out.println("é o caminho" + files[i].getName()); } } } } }
	 */
}
