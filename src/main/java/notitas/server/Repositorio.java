package notitas.server;

import notitas.json.Asignaciones;
import notitas.json.JSONParser;
import notitas.model.Alumno;

public class Repositorio {
    private static Repositorio ourInstance = new Repositorio();

    public static Repositorio getInstance() {
        return ourInstance;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public String getAlumnoAsJSON(){
        return getAsJSON(getAlumno());
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Asignaciones getAsignaciones(){
        return new Asignaciones(alumno.getTareas());
    }

    public String getAsignacionesAsJSON(){
        return getAsJSON(getAsignaciones());
    }

    private String getAsJSON(Object object) {
        return JSONParser.stringDesdeObjeto(object);
    }

    public void setAsignaciones(Asignaciones asignacion){
        alumno.setTareas(asignacion.getTareas());
    }

    private Alumno alumno;

    private Repositorio() {
    }
}
