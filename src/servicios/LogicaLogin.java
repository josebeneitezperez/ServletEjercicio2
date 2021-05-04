package servicios;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import main.java.clasesDAO.RolesDAO;
import main.java.clasesVO.Roles;
import main.java.clasesVO.Usuarios;
import main.java.controlador.ControladorUsuarios;

public class LogicaLogin {

	private static Logger logger = LogManager.getLogger(LogicaLogin.class);

	public static Usuarios comprobarContraseña(String nombre, String contraseñaIntroducida)
			throws ServletException, IOException {

		/*
		 * Map<String, String[]> parameters = request.getParameterMap(); for(String
		 * parameter : parameters.keySet()) System.out.println(parameter);
		 */
		
		// Contraseña sin cifrar
		Usuarios usuario = null;
		if ((nombre != null) && (contraseñaIntroducida != null)) {

			usuario = ControladorUsuarios.getEmpleados(nombre);

			if (usuario != null && usuario.getClave().equals(contraseñaIntroducida)) { // si no existe el usuario en la
																						// BD, no comprueba la clave
				logger.info("Login correcto");
				return usuario;
			}
		}
		
		//solo llegamos aquí si el login fue incorrecto
		logger.info("Login incorrecto");
		return usuario;	//null si no existe el usuario o falló la conexión con la BD

		
		// Contraseña cifrada
		/*
		Usuarios usuario = null;
		if ((nombre != null) && (contraseñaIntroducida != null)) {

			usuario = ControladorUsuarios.getEmpleados(nombre);

			// si no existe el usuario en la BD, no comprueba la clave
			if (usuario != null && UsuarioService.comparar(contraseñaIntroducida, usuario.getClave())) {
			
				logger.info("Login correcto");
				return usuario;
			} else {

				logger.info("Login incorrecto");
				return usuario;
			}
		} else {
			logger.info("Login incorrecto");
			return usuario;
		}
		*/
		
	}

	public static void crearVariablesSession(Usuarios usuario, HttpSession session, StringBuffer urlAnterior) {

		// nombre completo, fecha y hora
		String nombreCompleto = usuario.getNombre() + " " + usuario.getApellido1() + " " + usuario.getApellido2();
		String fechaHoraLogin = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:SS"));

		// variable de session, accesible en jsp con:
		// session = request.getSession(true);
		session.setAttribute("nombreUsuario", nombreCompleto);
		session.setAttribute("fechaHoraLogin", fechaHoraLogin);
		// variable de session. accedemos desde JSP con:
		// ${sessionScope.nombreUsuario}
		// ${nombreUsuario}
		// y desde java: session.getAttribute("nombreUsuario");

		// rolUsuario
		Roles rol = RolesDAO.getRolId(usuario.getIdRol());
		session.setAttribute("rolUsuario", rol.getRol());

		// URL anterior
		session.setAttribute("urlAnterior", urlAnterior);
	}
	
	public static String getPaginaSegunRol(String rolUsuario) {
		
		String paginaWeb = null;
		switch (rolUsuario) {

			case "Admin": {
				System.out.println("a");
				paginaWeb = "menuPrincipalAdmin.jsp";
				break;
			}
			case "Empleado": {
				paginaWeb = "menuPrincipalEmpleado.jsp";
				break;
			}
			case "Cliente": {
				paginaWeb = "menuPrincipalCliente.jsp";
				break;
			}
		}
		return paginaWeb;
	}
}











