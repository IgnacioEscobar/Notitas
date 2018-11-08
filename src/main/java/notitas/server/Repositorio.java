package notitas.server;

import notitas.json.Asignaciones;
import notitas.model.Alumno;

class Repositorio {
    private static Repositorio ourInstance = new Repositorio();
    private Alumno alumno;

    private Repositorio() {
    }

    static Repositorio getInstance() {
        return ourInstance;
    }

    Alumno getAlumno(Long id) {
        return alumno;
    }

    void setAlumno(Long id, Alumno alumno) {
        this.alumno = alumno;
    }

    Asignaciones getAsignaciones(Long id) {
        return new Asignaciones(alumno.getTareas());
    }

    void actualizarAlumno(Long id, Alumno nuevoAlumno) {
        nuevoAlumno.setTareas(alumno.getTareas());
        alumno = nuevoAlumno;
    }
}
