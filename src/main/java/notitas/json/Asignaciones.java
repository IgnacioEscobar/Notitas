package notitas.json;

import com.google.gson.annotations.SerializedName;
import notitas.model.Tarea;

import java.util.List;

public class Asignaciones {
    @SerializedName("assignments")
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
