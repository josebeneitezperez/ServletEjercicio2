package main.java.clasesDAO;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.java.clasesVO.Categorias;
import main.java.servlet.Login;

public class CategoriasDAO {
	
	private static Logger logger = LogManager.getLogger(CategoriasDAO.class);
	private static Session sesion = null;

	public static List<Categorias> getListaCategorias() {
		sesion = Login.abrirSesion();
		Transaction tx = sesion.beginTransaction();

		List<Categorias> lista = null;
		String query = "from Categorias order by id";
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
		return lista;
	}

	public static Categorias getCategoria(String nombreCategoria) {

		sesion = Login.abrirSesion();
		Categorias categoria = null;
		String hqlQuery = "from Categorias e where e.nombre = :nombreCategoria";

		try {
			categoria = sesion.createQuery(hqlQuery, Categorias.class).setParameter("nombreCategoria", nombreCategoria).setMaxResults(1)
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

	public static Categorias getCategoriaId(int id) {
		sesion = Login.abrirSesion();
		Transaction tx = sesion.beginTransaction();

		Categorias categoria = null;
		try {
			categoria = sesion.get(Categorias.class, id);
			tx.commit();
		} catch (Exception e) {
			logger.error("No se pudo obtener la categoria con el id: " + id + ", error: ", e);
		} finally {
			try {
				sesion.close();
			} catch (HibernateException e) {
				logger.error("No se pudo cerrar la conexión con la BD, error: ", e);
			}
		}
		return categoria;
	}

	public static void insert(Categorias categoria) {

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
