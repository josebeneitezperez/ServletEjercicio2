package main.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.java.clasesVO.Usuarios;
import main.java.controlador.ControladorUsuarios;
import main.java.controlador.HibernateUtil;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = LogManager.getLogger(Login.class);

	// private static String rutaLogs = "C:\\Users\\Formacion\\workspace
	// Jose\\EjercicioServlet2\\resources\\log4j.properties";
	private static String rutaLogs = "C:\\Users\\josec\\workspace CursoJava\\EjercicioServlet2\\resources\\log4j.properties";

	private static SessionFactory sessionFactory = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		PropertyConfigurator.configure(rutaLogs);
		logger.info("Aplicación iniciada");
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		abrirSesion();
	}

	public static Session abrirSesion() {
		if (sessionFactory == null) {
			sessionFactory = HibernateUtil.getSessionFactory();
		}
		return sessionFactory.openSession();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * Map<String, String[]> parameters = request.getParameterMap(); for(String
		 * parameter : parameters.keySet()) System.out.println(parameter);
		 */

		PrintWriter out = response.getWriter();
		String nombre = null;
		String contraseña = null;
		if (((nombre = request.getParameter("user")) != null)
				&& ((contraseña = request.getParameter("password")) != null)) {

			System.out.println("Usuario introducido: " + nombre + ". Y contraseña introducida: " + contraseña);

			Usuarios usuario = ControladorUsuarios.getEmpleados(nombre);

			if (usuario != null && usuario.getClave().equalsIgnoreCase(contraseña)) { // si no existe el usuario en la
																						// BD, no comprueba la clave
				printResponse(out, "Bienvenido " + nombre);

			} else {
				printResponse(out, "No puede acceder a la aplicación");
			}

			/*
			 * List<Usuarios>listaUsuarios = ControladorUsuarios.getEmpleados(nombre);
			 * if(listaUsuarios!=null) { for(Usuarios usuario: listaUsuarios) {
			 * if(usuario.getClave().equalsIgnoreCase(contraseña)) {
			 * 
			 * printResponse(out, "Bienvenido "+nombre);
			 * 
			 * }else { printResponse(out,
			 * "Error, la contraseña es incorrecta para el usuario "+nombre); } } } else {
			 * System.out.println("listaUsuarios vale null"); printResponse(out,
			 * "No existe el usuario con el nombre "+nombre+" en la BD"); }
			 * 
			 */

		} else {

			printResponse(out, "No puede acceder a la aplicación");
		}

		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.info("Recibida petición POST");
		doGet(request, response);
	}

	private PrintWriter printResponse(PrintWriter out, String mensaje) {

		PrintWriter res = out;

		res.println("<html>");
		res.println("<title>Login</title>");
		res.println("<body>");

		res.println(mensaje);

		res.println("</body>");
		res.println("</html>");

		return res;
	}
}
