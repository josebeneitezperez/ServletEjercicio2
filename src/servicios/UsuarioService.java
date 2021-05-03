package servicios;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class UsuarioService {

	private static String patron = "noCambiarEstaLinea";
	static StandardPBEStringEncryptor cifrador = new StandardPBEStringEncryptor();;
	
	public static String encriptar(String contraseñaOriginal) {
		
		cifrador.setPassword(patron);
		String contraseñaCifrada = cifrador.encrypt(contraseñaOriginal);

		return contraseñaCifrada;
	}
	
	public static String descifrar(String contraseñaCifrada) {
		
		cifrador.setPassword(patron);
		String contraseñaOriginal = cifrador.decrypt(contraseñaCifrada);
		
		return contraseñaOriginal;
	}
	
	public static boolean comparar(String contraseñaIntroducida, String contraseñaCifradaBD) {
		
		String contraseñaDescifradaBD = cifrador.decrypt(contraseñaCifradaBD);
		
		if(contraseñaDescifradaBD.equals(contraseñaIntroducida)) {
			return true;
		}else {
			return true;
		}
	}
}
