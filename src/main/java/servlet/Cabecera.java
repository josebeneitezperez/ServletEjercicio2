package main.java.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cabecera
 */
@WebServlet("/Cabecera")
public class Cabecera extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cabecera() {
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
		
		//<%=request.getHeader("Referer")%>
		
		if(request.getParameter("cerrar") != null) {	//Se ha pulsado el botón cerrar
			
			request.getSession().invalidate();
			request.getRequestDispatcher("login.html").forward(request, response);
			
		} else if(request.getParameter("volver") != null) {
			
			System.out.println("Intentando volver a "+request.getHeader("referer"));
			System.out.println("Intentando volver a "+request.getRequestURI());
			System.out.println("Intentando volver a "+request.getRequestURL());
			System.out.println("Intentando volver a "+request.getAttribute("urlAnterior"));
			System.out.println("Intentando volver a "+request.getHeader("Referer"));
			
			
			
			
			response.sendRedirect(request.getHeader("referer"));
			//request.getRequestDispatcher(request.getHeader("referer")).forward(request, response);
			
			
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
