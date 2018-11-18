package notitas.server.cargaInicial;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

public class AlumnoBase {
	public static void init() {
		EntityManager manager =  PerThreadEntityManagers.getEntityManager();
    	
    	Query query= manager.createNativeQuery("insert into alumno (userID, nombre, apellido, legajo, usuarioGitHub)\r\n" + 
		 		"values(1, 'Gabriel', 'Ruderman', 1587973, 'gabrielruderman')");
    }
}