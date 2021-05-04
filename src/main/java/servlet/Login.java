package main.java.servlet;

import java.io.IOException;  
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.java.clasesDAO.RolesDAO;
import main.java.clasesVO.Roles;
import main.java.clasesVO.Usuarios;
import main.java.controlador.ControladorUsuarios;
import main.java.controlador.HibernateUtil;
import servicios.LogicaLogin;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private static Logger logger = LogManager.getLogger(Login.class);
	private static String rutaLogs = "C:\\Users\\josec\\workspace CursoJava\\EjercicioServlet2\\resources\\log4j.properties";

	private static SessionFactory sessionFactory = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		PropertyConfigurator.configure(rutaLogs);
		logger.info("Aplicaci�n iniciada");
	}
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {	
		sessionFactory = HibernateUtil.getSessionFactory();
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
		
		Usuarios usuario = null;
		if((usuario =LogicaLogin.comprobarContrasena(request.getParameter("user"),  request.getParameter("password")))!=null) {
			
			HttpSession session = request.getSession(true);
			LogicaLogin.crearVariablesSession(usuario, session, request.getRequestURL());	
			
			String paginaSegunRol = LogicaLogin.getPaginaSegunRol((String)session.getAttribute("rolUsuario"));
			request.getRequestDispatcher(paginaSegunRol).forward(request, response);
			
		}else {
			request.getRequestDispatcher("loginInvalido.html").forward(request, response);
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.info("Recibida petici�n POST");
		doGet(request, response);
	}
}
