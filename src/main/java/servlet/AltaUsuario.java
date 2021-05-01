package main.java.servlet;

import java.io.IOException; 

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import main.java.clasesDAO.RolesDAO;
import main.java.clasesDAO.UsuariosDAO;
import main.java.clasesVO.Usuarios;

/**
 * Servlet implementation class AltaUsuario
 */
@WebServlet("/AltaUsuario")
public class AltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(AltaUsuario.class);
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AltaUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Insertar Usuario en la BD
		String nombreUsuario = null;
		String idRolString = null;
		
		if ((nombreUsuario = request.getParameter("nombre")) != "" && (idRolString = request.getParameter("idRol")) != "") { // si el nombre y el idRol no estan vacios

			if (UsuariosDAO.getUsuario(nombreUsuario) == null) { // si no existe el usuario, intenta crearlo

				int idRol = Integer.parseInt(idRolString);
				if (RolesDAO.getRolId(idRol) != null) { // si el rol introducido existe, crea al usuario
					
					String apellido1 = request.getParameter("apellido1");
					String apellido2 = request.getParameter("apellido2");
					String direccion = request.getParameter("direccion");
					String localidad = request.getParameter("localidad");
					String provincia = request.getParameter("provincia");
					String telefono = request.getParameter("telefono");
					String email = request.getParameter("email");
					String clave = request.getParameter("clave");
					String dni = request.getParameter("dni");

					Usuarios usuario = new Usuarios(idRol, email, clave, nombreUsuario, apellido1, apellido2, direccion,
							localidad, provincia, telefono, dni);
					UsuariosDAO.insert(usuario);
					
				} else {
					logger.info("No existe ningún rol en la BD con el ID proporcionado");
				}
				
			}else {
				logger.info("Se intentó crear un usuario cuyo nombre ya existe en la BD");
			}
			
		}else {
			logger.info("Se intentó dar de alta un usuario sin introducir su nombre o su rol");
		}
		
		//redirige a la misma página
		request.getRequestDispatcher("altaUsuario.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
