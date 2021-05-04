package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import main.java.clasesVO.Provincia;

public class LeerJsonUrl {

	public static void main(String[] args) {

		String cadenaJson = leerUrl("https://raw.githubusercontent.com/IagoLast/pselect/master/data/provincias.json");

		Provincia[] provincias = new Gson().fromJson(cadenaJson, Provincia[].class);

		List<Provincia> listaProvincias = new ArrayList<Provincia>(Arrays.asList((provincias)));

		for (Provincia provincia : listaProvincias) {
			System.out.println(provincia.toString());
		}

	}
	
	public static ArrayList<Provincia> getArrayListJson(){
		
		
		return null;
	}

	public static String leerUrl(String urlString) {

		String output = "";
		try {
			URL url = new URL(urlString);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			// conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				// si la respuesta del servidor es distinta al codigo 200 lanzaremos una
				// Exception
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			// creamos un StringBuilder para almacenar la respuesta del web service
			StringBuilder sb = new StringBuilder();
			int cp;
			while ((cp = br.read()) != -1) {
				sb.append((char) cp);
			}
			// en la cadena output almacenamos toda la respuesta del servidor
			output = sb.toString();
			// System.out.println(output);

			conn.disconnect();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return output;
	}
}
