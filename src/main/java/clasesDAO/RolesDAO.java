package main.java.clasesDAO;

import java.util.List; 

import org.apache.log4j.LogManager; 
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.java.clasesVO.Roles;
import main.java.servlet.Login;

public class RolesDAO {
	
	private static Logger logger = LogManager.getLogger(UsuariosDAO.class);
	private static Session sesion = null;

	public static List<Roles> getListaRoles() {
		sesion = Login.abrirSesion();
		Transaction tx = sesion.beginTransaction();

		List<Roles> lista = null;
		String query = "from Roles order by id";
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
	
	public static Roles getRol(String nombreRol) {
		
		sesion = Login.abrirSesion();
		Roles rol = null;
		String hqlQuery = "from Roles e where e.rol = :nombreRol";
		
		try {
			//listaUsuarios = sesion.createQuery(hqlQuery, Usuarios.class).setParameter("nombreRol", nombre).list();
			rol = sesion.createQuery(hqlQuery, Roles.class).setParameter("nombreRol", nombreRol).setMaxResults(1).uniqueResult();

		} catch (Exception e) {
			logger.error("Error al ejecutar la Query " + hqlQuery + ", error: ", e);
		} finally {
			try {
				sesion.close();
			} catch (HibernateException e) {
				logger.error("No se pudo cerrar la conexión con la BD, error: ", e);
			}
		}
		
		return rol;
	}
	
	public static Roles getRolId(int id) {
		sesion =Login.abrirSesion();
		Transaction tx = sesion.beginTransaction();
		
		Roles rol = null;
		try {
			rol = sesion.get(Roles.class, id);
			tx.commit();
		} catch (Exception e) {
			logger.error("No se pudo obtener el rol con el id: " + id + ", error: ", e);
		} finally {
			try {
				sesion.close();
			} catch (HibernateException e) {
				logger.error("No se pudo cerrar la conexión con la BD, error: ", e);
			}
		}
		return rol;
	}
	
	public static void insert(Roles rol) {

		sesion = Login.abrirSesion();
		Transaction tx = sesion.beginTransaction();
		
		try {
			sesion.save(rol);
			tx.commit();
		} catch (Exception e) {
			logger.error("No se pudo insertar el rol : " + rol.getRol() + ", error: ", e);
		} finally {
			try {
				sesion.close();
			} catch (HibernateException e) {
				logger.error("No se pudo cerrar la conexión con la BD, error: ", e);
			}
		}
	}
}
