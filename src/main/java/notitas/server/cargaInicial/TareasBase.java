package notitas.server.cargaInicial;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import notitas.model.Tarea;

public class TareasBase {
	public static void init() {
		EntityManager manager =  PerThreadEntityManagers.getEntityManager();
    	
    	Query query= manager.createNativeQuery("insert into tarea (descripcion, notas, notaActual, alumno_id)\r\n" + 
		 		"values('moduloB', 9, 9, 1)");
    }
}
