package main.java.clasesDAO;


import java.util.List; 

import org.apache.log4j.LogManager; 
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.java.clasesVO.Roles;
import main.java.clasesVO.Usuarios;
import main.java.servlet.Login;

public class UsuariosDAO {

	private static Logger logger = LogManager.getLogger(UsuariosDAO.class);
	private static Session sesion = null;

	public static List<Usuarios> getListaUsuarios() {
		sesion = Login.abrirSesion();
		Transaction tx = sesion.beginTransaction();

		List<Usuarios> lista = null;
		String query = "from Usuarios order by id";
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
	
	public static Usuarios getUsuario(String nombre) {
		
		sesion = Login.abrirSesion();
		Usuarios usuario = null;
		String hqlQuery = "from Usuarios e where e.nombre = :nombre";
		
		try {
			//listaUsuarios = sesion.createQuery(hqlQuery, Usuarios.class).setParameter("nombre", nombre).list();
			usuario = sesion.createQuery(hqlQuery, Usuarios.class).setParameter("nombre", nombre).setMaxResults(1).uniqueResult();

		} catch (Exception e) {
			logger.error("Error al ejecutar la Query " + hqlQuery + ", error: ", e);
		} finally {
			try {
				sesion.close();
			} catch (HibernateException e) {
				logger.error("No se pudo cerrar la conexión con la BD, error: ", e);
			}
		}
		
		return usuario;
	}
	
	public static void insert(Usuarios usuario) {

		sesion = Login.abrirSesion();
		Transaction tx = sesion.beginTransaction();
		
		try {
			sesion.save(usuario);
			tx.commit();
		} catch (Exception e) {
			logger.error("No se pudo insertar el usuario : " + usuario.getNombre() + ", error: ", e);
		} finally {
			try {
				sesion.close();
			} catch (HibernateException e) {
				logger.error("No se pudo cerrar la conexión con la BD, error: ", e);
			}
		}
	}
}
