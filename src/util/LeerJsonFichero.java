package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import main.java.clasesVO.Provincia;


public class LeerJsonFichero {

	public static void main(String[] args) {
		
		String cadenaJson = leerFichero("C:\\xampp\\htdocs\\persona.json");
     
		/*		//original
		Provincia provincia = new Gson().fromJson(cadenaJson, Provincia.class);
		
		String nombre = persona.getNombre();
		System.out.println(nombre);
		*/
		
		//probando MAL
		Provincia[] provincias = new Gson().fromJson(cadenaJson, Provincia[].class);

		List<Provincia> listaProvincias = new ArrayList<Provincia>(Arrays.asList((provincias)));

		for (Provincia provincia : listaProvincias) {
			System.out.println(provincia.toString());
		}
	}

	public static String leerFichero(String fichero) {
		String output = "";
		
		try {
			FileReader f = new FileReader(fichero);
	
	        BufferedReader b = new BufferedReader(f);

	        String cadenaLeida;
	        while ((cadenaLeida = b.readLine()) != null) {
	        	output += cadenaLeida;
	        }
	        b.close();
	        
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return output;		
	}
}
