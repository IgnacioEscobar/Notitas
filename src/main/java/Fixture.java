import client.RestClient;
import json.JSONParser;
import model.Alumno;
import model.Tarea;

public class Fixture {
	
	public static void init() {
        
        RestClient cliente = new RestClient("http://notitas.herokuapp.com/");
        JSONParser parser = new JSONParser();
        Alumno alumno = parser.objetoDesdeString(cliente.getResource("student"), Alumno.class);
        Alumno.setInstance(alumno);
        Tarea tarea = new Tarea("1 Parcial");
        tarea.evaluar("7");
        alumno.asignarTarea(tarea);
        Tarea tarea2 = new Tarea("2 Parcial");
        tarea2.evaluar("4");
        alumno.asignarTarea(tarea2);
        Tarea tarea3 = new Tarea("Trabajo anual");
        tarea3.evaluar("B");
        alumno.asignarTarea(tarea3);
        
	}

}
