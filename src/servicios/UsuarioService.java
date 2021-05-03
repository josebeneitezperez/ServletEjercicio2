package servicios;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class UsuarioService {

	private static String patron = "noCambiarEstaLinea";
	static StandardPBEStringEncryptor cifrador = new StandardPBEStringEncryptor();;
	
	public static String encriptar(String contrase�aOriginal) {
		
		cifrador.setPassword(patron);
		String contrase�aCifrada = cifrador.encrypt(contrase�aOriginal);

		return contrase�aCifrada;
	}
	
	public static String descifrar(String contrase�aCifrada) {
		
		cifrador.setPassword(patron);
		String contrase�aOriginal = cifrador.decrypt(contrase�aCifrada);
		
		return contrase�aOriginal;
	}
	
	public static boolean comparar(String contrase�aIntroducida, String contrase�aCifradaBD) {
		
		String contrase�aDescifradaBD = cifrador.decrypt(contrase�aCifradaBD);
		
		if(contrase�aDescifradaBD.equals(contrase�aIntroducida)) {
			return true;
		}else {
			return true;
		}
	}
}
