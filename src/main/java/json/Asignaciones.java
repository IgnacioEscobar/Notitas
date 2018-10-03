package json;

import model.Tarea;

import java.util.List;

public class Asignaciones {
    private List<Tarea> tareas;

    public Asignaciones() {
    }

    public Asignaciones(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
}
