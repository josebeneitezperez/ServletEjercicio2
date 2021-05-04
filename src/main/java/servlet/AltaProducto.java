package main.java.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.clasesDAO.ProductosDAO;
import main.java.clasesDAO.UsuariosDAO;
import main.java.clasesVO.Productos;
import util.Util;

/**
 * Servlet implementation class AltaProducto
 */
@WebServlet("/AltaProducto")
public class AltaProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaProducto() {
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
		
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		double precio = Double.parseDouble(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		Date fechaAlta = new Date();	//Util.stringATimestamp(new Date().toString());
		Date fechaBaja = null;
		Float impuesto = Float.parseFloat(request.getParameter("impuesto"));
		
		Productos producto = new Productos(categoria, nombre,  descripcion,  precio,  stock,
				 fechaAlta,  fechaBaja,  impuesto);
		
		String mensaje;
		if(ProductosDAO.insert(producto)) {
			mensaje = "Se insertó el producto";
		} else {
			mensaje = "No se pudo insertar el producto";
		}
		
		request.getSession(true).setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("altaProducto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
