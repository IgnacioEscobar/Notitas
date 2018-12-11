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
    EntityManager manager;

    private Repositorio() {
        manager = PerThreadEntityManagers.getEntityManager();
    }

    public static Repositorio getInstance() {
        return ourInstance;
    }

    Alumno getAlumno(Long userID) {
        Alumno alumno = (Alumno) manager
                .createQuery("from Alumno where id = ?1")
                .setParameter(1, userID)
                .getResultList()
                .get(0);
		
        return alumno;
    }

    Asignaciones getAsignaciones(Long userID) {
       List tareas = manager
                .createQuery("from Tarea where alumno_id = ?1")
                .setParameter(1, userID)
                .getResultList();
		
		return new Asignaciones(tareas);
    }

    void actualizarAlumno(Long userID, Alumno nuevoAlumno) {
        manager.merge(nuevoAlumno);
    }
}
