package notitas.server.cargaInicial;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

public class AlumnoBase {
	public static void init() {
		
		EntityTransaction trans = null;
		try {
			EntityManager em = PerThreadEntityManagers.getEntityManager();
			trans = em.getTransaction();
			trans.begin();
			
			em.createNativeQuery("create table alumno (userID (number), nombre (char(40)), apellido (char(40)),"
					+ "legajo (number), usuarioGitHub (char(40))").executeUpdate();
			em.createNativeQuery("insert into alumno (userID, nombre, apellido, legajo, usuarioGitHub)\r\n" + 
			 		"values(1, 'Gabriel', 'Ruderman', 1587973, 'gabrielruderman')").executeUpdate();

			trans.commit();
		}
		catch (Throwable e) {
			if (trans != null && trans.isActive()) {
				trans.rollback();
			}
			throw e;
		}
    }
}