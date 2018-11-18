package notitas.server;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import notitas.json.Asignaciones;
import notitas.model.Alumno;
import notitas.model.Tarea;

public class Repositorio {
    private static Repositorio ourInstance = new Repositorio();
    private Alumno alumno;

    private Repositorio() {
    }

    public static Repositorio getInstance() {
        return ourInstance;
    }

    Alumno getAlumno(Long userID) {
    	EntityManager manager =  PerThreadEntityManagers.getEntityManager();
    	
    	Query query= manager.createNativeQuery("select *\r\n" + 
		 		"from alumno\r\n" + 
		 		"where id = ?1");
	      
		query.setParameter(1, userID);
		 
		List<Alumno> alumnos =  query.getResultList();
		
		alumno = alumnos.get(0);
		
        return alumno;
    }

    public void setAlumno(Long id, Alumno alumno) {
        this.alumno = alumno;
    }

    Asignaciones getAsignaciones(Long userID) {
    	EntityManager manager =  PerThreadEntityManagers.getEntityManager();
    	
    	Query query= manager.createNativeQuery("select T.descripcion, T.notas, T.nota_actual\r\n" + 
		 		"from tarea T join alumno A on T.alumno_id = A.id\r\n" + 
		 		"where id = ?1");
	      
		query.setParameter(1, userID);
		 
		List<Tarea> tareas =  query.getResultList();
		
		return new Asignaciones(tareas);
    }

    void actualizarAlumno(Long userID, Alumno nuevoAlumno) {
        nuevoAlumno.setTareas(alumno.getTareas());
        alumno = nuevoAlumno;
    }
}
