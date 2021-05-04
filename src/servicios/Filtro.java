package servicios;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Filtro implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest peticion=(HttpServletRequest)request;
		HttpSession session = peticion.getSession(false);	//(false) = si no existe la session no la crea (session=null)
		 
		HttpServletResponse respuesta=(HttpServletResponse)response;
		 
		 System.out.println("Filtro invocado");
		 
		if(session != null) {
			chain.doFilter(request, response);
		} else {
			respuesta.sendRedirect("login.html");
			//request.getRequestDispatcher("login.html").forward(request, response);
		}
	}

}