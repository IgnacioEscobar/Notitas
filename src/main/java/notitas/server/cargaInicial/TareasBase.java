package notitas.server.cargaInicial;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

public class TareasBase {
	public static void init() {	
	
		EntityTransaction trans = null;
		try {
			EntityManager em = PerThreadEntityManagers.getEntityManager();
			trans = em.getTransaction();
			trans.begin();
			
			em.createNativeQuery("create table tarea (id (number), descripcion (char(80)), notas (char(20)),"
					+ "notaActual (char(20)),").executeUpdate();
			em.createNativeQuery("insert into tarea (descripcion, notas, notaActual, alumno_id)\r\n" + 
			 		"values('moduloB', 9, 9, 1)").executeUpdate();
	
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
