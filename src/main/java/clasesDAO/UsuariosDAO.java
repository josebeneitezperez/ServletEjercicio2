package main.java.clasesDAO;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import main.java.clasesVO.Usuarios;
import main.java.servlet.Login;


public class UsuariosDAO {

	private static Logger logger = LogManager.getLogger(UsuariosDAO.class);
	private static Session sesion = null;

	public static Usuarios getUsuario(String nombre) {
		
		//una consulta no necesita Transaction para nada
		
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
}
