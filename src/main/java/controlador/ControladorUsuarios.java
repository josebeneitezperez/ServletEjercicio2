package main.java.controlador;

import main.java.clasesDAO.UsuariosDAO;
import main.java.clasesVO.Usuarios;

public class ControladorUsuarios {

	public static Usuarios getEmpleados(String nombre){
		return UsuariosDAO.getUsuario(nombre);
	}
}
