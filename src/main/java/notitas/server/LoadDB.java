package notitas.server;

import notitas.model.Alumno;
import notitas.model.Tarea;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LoadDB {
    public static void main(String[] args) {

        EntityManager em = PerThreadEntityManagers.getEntityManager();
        EntityTransaction trans = em.getTransaction();

        Alumno alumno = new Alumno();
        alumno.setNombre("Roque");
        alumno.setNombre("Fort");
        alumno.setLegajo(12312413);
        alumno.setUsuarioGitHub("maiameee666");

        Tarea tarea = new Tarea("1 Parcial");
        tarea.evaluar("7");
        alumno.asignarTarea(tarea);

        Tarea tarea2 = new Tarea("2 Parcial");
        tarea2.evaluar("7");
        alumno.asignarTarea(tarea2);

        Tarea tarea4 = new Tarea("Trabajo practico");
        tarea4.evaluar("B");
        alumno.asignarTarea(tarea4);

        Tarea tarea3 = new Tarea("Final");
        tarea3.evaluar("9");
        alumno.asignarTarea(tarea3);

        trans.begin();
        em.persist(alumno);
        trans.commit();

    }
}
