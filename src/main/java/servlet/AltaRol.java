package main.java.servlet;

import java.io.IOException; 
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import main.java.clasesDAO.RolesDAO;
import main.java.clasesVO.Roles;

/**
 * Servlet implementation class AltaRol
 */
@WebServlet("/AltaRol")
public class AltaRol extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LogManager.getLogger(AltaRol.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaRol() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre;
		if((nombre = request.getParameter("nombre"))!="") {	//si el nombre no está vacío
		
			if (RolesDAO.getRol(nombre) == null) { // Si no existe un rol con ese nombre, lo inserta
				RolesDAO.insert(new Roles(nombre));
			}else {
				logger.info("Se intentó crear un rol ya existente en la BD");
			}
		}else {
			logger.info("Se intentó crear un rol sin rellenar el campo \"nombre\"");
		}
		//redirige a la misma página
		request.getRequestDispatcher("altaRol.html").forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}







