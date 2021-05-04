package main.java.clasesDAO;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.java.clasesVO.Productos;
import main.java.servlet.Login;

public class ProductosDAO {

	private static Logger logger = LogManager.getLogger(ProductosDAO.class);
	private static Session sesion = null;

	public static List<Productos> getListaProductos() {
		sesion = Login.abrirSesion();
		Transaction tx = sesion.beginTransaction();

		List<Productos> lista = null;
		String query = "from Productos order by id";
		try {
			lista = sesion.createQuery(query).list();
			tx.commit();
		} catch (Exception e) {
			logger.error("Error al ejecutar la Query " + query + ", error: ", e);
		} finally {
			try {
				sesion.close();
			} catch (HibernateException e) {
				logger.error("No se pudo cerrar la conexión con la BD, error: ", e);
			}
		}
		
		System.out.println("ListaProductos tiene "+lista.size()+" productos");
		
		return lista;
	}

	public static Productos getProducto(String nombreProducto) {

		sesion = Login.abrirSesion();
		Productos categoria = null;
		String hqlQuery = "from Productos e where e.nombre = :nombreProducto";

		try {
			categoria = sesion.createQuery(hqlQuery, Productos.class).setParameter("nombreProducto", nombreProducto).setMaxResults(1)
					.uniqueResult();

		} catch (Exception e) {
			logger.error("Error al ejecutar la Query " + hqlQuery + ", error: ", e);
		} finally {
			try {
				sesion.close();
			} catch (HibernateException e) {
				logger.error("No se pudo cerrar la conexión con la BD, error: ", e);
			}
		}

		return categoria;
	}

	public static Productos getProductoId(int id) {
		sesion = Login.abrirSesion();
		Transaction tx = sesion.beginTransaction();

		Productos categoria = null;
		try {
			categoria = sesion.get(Productos.class, id);
			tx.commit();
		} catch (Exception e) {
			logger.error("No se pudo obtener el producto con el id: " + id + ", error: ", e);
		} finally {
			try {
				sesion.close();
			} catch (HibernateException e) {
				logger.error("No se pudo cerrar la conexión con la BD, error: ", e);
			}
		}
		return categoria;
	}

	public static void insert(Productos categoria) {

		sesion = Login.abrirSesion();
		Transaction tx = sesion.beginTransaction();

		try {
			sesion.save(categoria);
			tx.commit();
		} catch (Exception e) {
			logger.error("No se pudo insertar la categoria : " + categoria.getNombre() + ", error: ", e);
		} finally {
			try {
				sesion.close();
			} catch (HibernateException e) {
				logger.error("No se pudo cerrar la conexión con la BD, error: ", e);
			}
		}
	}
}
