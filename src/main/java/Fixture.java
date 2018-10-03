import client.RestClient;
import json.Asignaciones;
import json.JSONParser;
import model.Alumno;
import model.Tarea;

public class Fixture {
	
	public static void init() {
        
        RestClient cliente = new RestClient("http://notitas.herokuapp.com/");
        Alumno alumno = JSONParser.objetoDesdeString(cliente.getResource("student"), Alumno.class);
        Alumno.setInstance(alumno);
        Asignaciones asignaciones = JSONParser.objetoDesdeString(cliente.getResource("student/assignments"), Asignaciones.class);
        Alumno.getInstance().setTareas(asignaciones.getTareas());
	}

}
