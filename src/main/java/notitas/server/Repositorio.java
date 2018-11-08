package notitas.server;

import notitas.json.Asignaciones;
import notitas.json.JSONParser;
import notitas.model.Alumno;

public class Repositorio {
    private static Repositorio ourInstance = new Repositorio();

    public static Repositorio getInstance() {
        return ourInstance;
    }

    public Alumno getAlumno(Long id) {
        return alumno;
    }

    public void setAlumno(Long id, Alumno alumno) {
        this.alumno = alumno;
    }

    public Asignaciones getAsignaciones(Long id){
        return new Asignaciones(alumno.getTareas());
    }

    public void setAsignaciones(Asignaciones asignacion){
        alumno.setTareas(asignacion.getTareas());
    }

    private Alumno alumno;

    private Repositorio() {
    }

    public void actualizarAlumno(Long id, Alumno nuevoAlumno) {
        nuevoAlumno.setTareas(alumno.getTareas());
        alumno = nuevoAlumno;
    }
}
