package servicios;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class UsuarioService {

	private static String patron = "noCambiarEstaLinea";
	static StandardPBEStringEncryptor cifrador = new StandardPBEStringEncryptor();;
	
	public static String encriptar(String contrasenaOriginal) {
		
		cifrador.setPassword(patron);
		String contrasenaCifrada = cifrador.encrypt(contrasenaOriginal);

		return contrasenaCifrada;
	}
	
	public static String descifrar(String contrasenaCifrada) {
		
		cifrador.setPassword(patron);
		String contrasenaOriginal = cifrador.decrypt(contrasenaCifrada);
		
		return contrasenaOriginal;
	}
	
	public static boolean comparar(String contrasenaIntroducida, String contrasenaCifradaBD) {
		
		String contrasenaDescifradaBD = cifrador.decrypt(contrasenaCifradaBD);
		
		if(contrasenaDescifradaBD.equals(contrasenaIntroducida)) {
			return true;
		}else {
			return true;
		}
	}
}
