package notitas.client;

import notitas.json.Asignaciones;
import notitas.json.JSONParser;
import notitas.model.Alumno;
import notitas.model.Tarea;

import java.util.List;

public class NotitasClient {
    private RestClient cliente;

    public NotitasClient(String url) {
        this.cliente = new RestClient(url);
    }

    public Alumno getAlumno() {
        return JSONParser.objetoDesdeString(cliente.getResource("student"), Alumno.class);
    }

    public List<Tarea> getTareas() {
        return JSONParser.objetoDesdeString(cliente.getResource("student/assignments"), Asignaciones.class).getTareas();
    }

    public void putAlumno(Alumno alumno) {
        cliente.putResource("student", JSONParser.stringDesdeObjeto(alumno));
    }
}
